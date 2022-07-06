#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<iostream>
//#include<io.h>

#define MAXINODE 50

#define READ 1
#define WRITE 2

#define MAXFILESIZE 1024

#define REGULAR 1
#define SPECIAL 2

#define START 0
#define CURRENT 1
#define END 2

typedef struct superblock
{
   int TotalInodes;
   int FreeInode;
}SUPERBLOCK, *PSUPERBLOCK;

typedef struct inode
{
   char FileName[50];
   int InodeNumber;
   int FileSize;
   int FileActualSize;
   int FileType;
   char *Buffer;
   int LinkCount;
   int ReferenceCount;
   int permission; //1 2 3
   struct inode *next;
}INODE,*PINODE,**PPINODE;  //Inline Typedef

typedef struct filetable
{
   int readoffset;  //hard disk var madhe ekach offset asto
   int writeoffset;
   int count;
   int mode; //1 2 3
   PINODE ptrinode;
}FILETABLE, *PFILETABLE;

typedef struct ufdt
{
   PFILETABLE ptrfiletable;
}UFDT;

UFDT UFDTArr[MAXINODE];
SUPERBLOCK SUPERBLOCKobj;
PINODE head = NULL;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : man
// Input Parameters : Character pointer
// Return value of function : Void
// Description of the function : The function is used to implement man command which allows user to view the manual of commands. 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void man(char *name)
{
   if(name == NULL) return;

   if(strcmp(name,"create") == 0)
   {
      printf("Description : Used to create new regular file\n");
      printf("Usage : create File_name Permission\n");
   }
   else if(strcmp(name,"read") == 0)
   {
      printf("Description : Used to read the data from regular file\n");
      printf("Usage : read File_name No_Of_Bytes_To_Read\n");
   }
   else if(strcmp(name,"write") == 0)
   {
      printf("Description : Used to write into regular file\n");
      printf("Usage : write File_name\n After this enter the data that you want to write\n");
   }
   else if(strcmp(name,"ls") == 0)
   {
      printf("Description : Used to list all the information of files\n");
      printf("Usage : ls\n");
   }
   else if(strcmp(name,"stat") == 0)
   {
      printf("Description : Used to display information of file\n");
      printf("Usage : stat File_name\n");
   }
   else if(strcmp(name,"fstat") == 0)
   {
      printf("Description : Used to display information of file\n\n");
      printf("Usage : fstat File_Descriptor\n");
   }
   else if(strcmp(name,"truncate") == 0)
   {
      printf("Description : Used to remove the data from the file\n");
      printf("Usage : truncate File_name\n");
   }
   else if(strcmp(name,"open") == 0)
   {
      printf("Description : Used to open existing file\n");
      printf("Usage : open File_name mode\n");
   }
   else if(strcmp(name,"close") == 0)
   {
      printf("Description : Used to close opened file\n");
      printf("Usage : close File_name\n");
   }
   else if(strcmp(name,"closeall") == 0)
   {
      printf("Description : Used to close all opened files\n");
      printf("Usage : closeall\n");
   }
   else if(strcmp(name,"lseek") == 0)
   {
      printf("Description : Used to change file offset\n");
      printf("Usage : lseek File_name ChangeInOffset StartPoint\n");
   }
   else if(strcmp(name,"rm") == 0)
   {
      printf("Description : Used to delete the file\n");
      printf("Usage : rm File_name\n");
   }
   else
   {
      printf("ERROR : No manual entry available\n");
   }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : DisplayHelp
// Input Parameters : No input parameters
// Return value of function : Void
// Description of the function : The function is used to implement help command which is used to learn more about command's usage. 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void DisplayHelp()
{
   printf("ls : To List out all the files\n");
   printf("clear : To Clear console\n");
   printf("open : To Open the file\n");
   printf("close : To Close the file\n");
   printf("closeall : To Close All opened files\n");
   printf("read : To Read the contents from the file\n");
   printf("write : To Write the contents into file\n");
   printf("exit : To Terminate the system\n");
   printf("stat : To Display information of file using name\n");
   printf("fstat : To Display information of file using descriptor\n");
   printf("truncate : to remove all data from file\n");
   printf("rm : To Delete the file\n");
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : GetFDFromName
// Input Parameters : Character pointer
// Return value of function : Integer
// Description of the function : The function is used to get file descriptor from the name of the file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int GetFDFromName(char *name)
{
   int i = 0;

   while(i<MAXINODE)
   {
      if(UFDTArr[i].ptrfiletable != NULL && (UFDTArr[i].ptrfiletable->ptrinode->FileType) != 0 )
        if(strcmp((UFDTArr[i].ptrfiletable->ptrinode->FileName),name) == 0)
          break;
       
       i++;
   }
   if(i == MAXINODE) return -1;
   else return i;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : Get_Inode
// Input Parameters : Character pointer
// Return value of function : Pointer to Inode
// Description of the function : The function is used to get inode of the file from inode structure
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

PINODE Get_Inode(char *name)
{
   PINODE temp = head;
   int i = 0;

   if(name == NULL)
     return NULL;
   
   while(temp != NULL)
   {
      if(strcmp(name,temp->FileName) == 0)
          break;
      temp = temp->next;
   }
   return temp;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : CreateDILB
// Input Parameters : No input parameters
// Return value of function : void
// Description of the function : The function is used to create disk inode list block using linked list  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void CreateDILB()
{
   int i = 1;
   PINODE newn = NULL;
   PINODE temp = head;

   while(i<= MAXINODE)
   {
      newn = (PINODE)malloc(sizeof(INODE));

      newn->LinkCount = 0;
      newn->ReferenceCount = 0;
      newn->FileType = 0;
      newn->FileSize = 0;

      newn->Buffer = NULL;
      newn->next = NULL;

      newn->InodeNumber = i;

      if(temp == NULL)
      {
        head = newn;
        temp = head;
      }
      else
      {
        temp->next = newn;
        temp = temp->next;
      }
      i++;
   }
   printf("DILB created successfully\n");
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : InitializeSuperBlock
// Input Parameters : No input parameters
// Return value of function : void
// Description of the function : The function is used to initialize super block data
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void InitialiseSuperBlock()
{
   int i = 0;
   while(i<MAXINODE)   // segmentation fault deu naye garbage deun as it is pointer
   {
      UFDTArr[i].ptrfiletable = NULL;
      i++;
   }

   SUPERBLOCKobj.TotalInodes = MAXINODE;
   SUPERBLOCKobj.FreeInode = MAXINODE;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : CreateFile
// Input Parameters : Character pointer, Integer
// Return value of function : Integer
// Description of the function : The function is used to implement create command to create file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int CreateFile(char *name,int permission)
{
   int i = 0;
   PINODE temp = head;

   if((name == NULL) || (permission == 0) || (permission > 3))
     return -1;
   if(SUPERBLOCKobj.FreeInode == 0)
     return -2;
   
   (SUPERBLOCKobj.FreeInode)--;

   if(Get_Inode(name) != NULL)
     return -3;

   while(temp != NULL)
   {
      if(temp->FileType == 0)
        break;
      temp = temp->next;
   }
   while(i<50)
   {
       if(UFDTArr[i].ptrfiletable == NULL)
         break;
       i++;
   }
  
   UFDTArr[i].ptrfiletable = (PFILETABLE)malloc(sizeof(FILETABLE));

   UFDTArr[i].ptrfiletable->count = 1;
   UFDTArr[i].ptrfiletable->mode = permission;
   UFDTArr[i].ptrfiletable->readoffset = 0;
   UFDTArr[i].ptrfiletable->writeoffset = 0;

   UFDTArr[i].ptrfiletable->ptrinode = temp;

   strcpy(UFDTArr[i].ptrfiletable->ptrinode->FileName,name);
   UFDTArr[i].ptrfiletable->ptrinode->FileType = REGULAR;
   UFDTArr[i].ptrfiletable->ptrinode->ReferenceCount = 1;
   UFDTArr[i].ptrfiletable->ptrinode->LinkCount = 1;
   UFDTArr[i].ptrfiletable->ptrinode->FileSize = MAXFILESIZE; 
   UFDTArr[i].ptrfiletable->ptrinode->FileActualSize = 0;
   UFDTArr[i].ptrfiletable->ptrinode->permission = permission;
   UFDTArr[i].ptrfiletable->ptrinode->Buffer = (char *)malloc(MAXFILESIZE);

   return i;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : rm_File
// Input Parameters : Character pointer
// Return value of function : Integer
// Description of the function : The function is used to implement rm command to remove file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int rm_File(char *name)
{
   int fd = 0;

   fd = GetFDFromName(name);
   if(fd == -1)
     return -1;

   (UFDTArr[fd].ptrfiletable->ptrinode->LinkCount)--;

   if(UFDTArr[fd].ptrfiletable->ptrinode->LinkCount == 0)
   {
      UFDTArr[fd].ptrfiletable->ptrinode->FileType = 0;
      free(UFDTArr[fd].ptrfiletable);
   }
   UFDTArr[fd].ptrfiletable = NULL;
   (SUPERBLOCKobj.FreeInode)++;

   return 0;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : ReadFile
// Input Parameters : Integer, Character pointer, Integer
// Return value of function : Integer
// Description of the function : The function is used to implement read command to read data from file
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int ReadFile(int fd, char *arr, int isize)
{
   int read_size = 0;

   if(UFDTArr[fd].ptrfiletable == NULL)  return -1;
   
   if(((UFDTArr[fd].ptrfiletable->mode) != READ) && ((UFDTArr[fd].ptrfiletable->mode) != READ+WRITE)) return -2;
   
   if(((UFDTArr[fd].ptrfiletable->ptrinode->permission) != READ) && ((UFDTArr[fd].ptrfiletable->ptrinode->permission) != READ+WRITE)) return -2;

   if(UFDTArr[fd].ptrfiletable->readoffset == UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) return -3;
   
   if((UFDTArr[fd].ptrfiletable->ptrinode->FileType) != REGULAR) return -4;

   read_size = (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) - (UFDTArr[fd].ptrfiletable->readoffset);

   if(read_size < isize)
   {
      strncpy(arr,(UFDTArr[fd].ptrfiletable->ptrinode->Buffer)+(UFDTArr[fd].ptrfiletable->readoffset),read_size);

      UFDTArr[fd].ptrfiletable->readoffset = UFDTArr[fd].ptrfiletable->readoffset + read_size;
   }
   else
   {
      strncpy(arr,(UFDTArr[fd].ptrfiletable->ptrinode->Buffer)+(UFDTArr[fd].ptrfiletable->readoffset),isize);

      UFDTArr[fd].ptrfiletable->readoffset = UFDTArr[fd].ptrfiletable->readoffset + isize;
   }
   return isize;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : WriteFile
// Input Parameters : Integer, Character pointer, Integer
// Return value of function : Integer
// Description of the function : The function is used to implement write command to write into file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int WriteFile(int fd, char *arr, int isize)
{
   if(((UFDTArr[fd].ptrfiletable->mode) != WRITE) && ((UFDTArr[fd].ptrfiletable->mode) != READ+WRITE)) return -1;

   if(((UFDTArr[fd].ptrfiletable->ptrinode->permission) != WRITE) && ((UFDTArr[fd].ptrfiletable->ptrinode->permission) != READ+WRITE)) return -1;
   
   if((UFDTArr[fd].ptrfiletable->writeoffset) == MAXFILESIZE) return -2;

   if((UFDTArr[fd].ptrfiletable->ptrinode->FileType) != REGULAR) return -3;

   if(((UFDTArr[fd].ptrfiletable->writeoffset) + isize) > MAXFILESIZE) return -4;

   strncpy((UFDTArr[fd].ptrfiletable->ptrinode->Buffer) + (UFDTArr[fd].ptrfiletable->writeoffset),arr,isize);

   (UFDTArr[fd].ptrfiletable->writeoffset) = (UFDTArr[fd].ptrfiletable->writeoffset) + isize;

   (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) = (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) + isize;

   return isize;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : OpenFile
// Input Parameters : Character pointer, Integer
// Return value of function : Integer
// Description of the function : The function is used to implement open command to open the file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int OpenFile(char *name,int mode)
{
   int i = 0;
   PINODE temp = NULL;

   if(name == NULL || mode <= 0)
      return -1;
   
   temp = Get_Inode(name);
   if(temp == NULL)
       return -2;
   
   if(temp->permission < mode)
      return -3;

   while(i<50)
   {
      if(UFDTArr[i].ptrfiletable == NULL)
          break;
      i++;
   }

   UFDTArr[i].ptrfiletable = (PFILETABLE)malloc(sizeof(FILETABLE));
   if(UFDTArr[i].ptrfiletable == NULL) return -1;
   UFDTArr[i].ptrfiletable->count = 1;
   UFDTArr[i].ptrfiletable->mode = mode;
   if(mode == READ+WRITE)
   {
      UFDTArr[i].ptrfiletable->readoffset = 0;
      UFDTArr[i].ptrfiletable->writeoffset = 0;
   }
   else if(mode == READ)
   {
      UFDTArr[i].ptrfiletable->readoffset = 0;
   }
   else if(mode == WRITE)
   {
      UFDTArr[i].ptrfiletable->writeoffset = 0;
   }
   UFDTArr[i].ptrfiletable->ptrinode = temp;
   (UFDTArr[i].ptrfiletable->ptrinode->ReferenceCount)++;

   return i;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : CloseFile
// Input Parameters : Integer
// Return value of function : Void
// Description of the function : The function is used to implement close command to close the file based on file descriptor
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void CloseFile(int fd)
{
   UFDTArr[fd].ptrfiletable->readoffset = 0;
   UFDTArr[fd].ptrfiletable->writeoffset = 0;
   (UFDTArr[fd].ptrfiletable->ptrinode->ReferenceCount)--;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : CloseFile
// Input Parameters : Character pointer
// Return value of function : Integer
// Description of the function : The function is used to implement close command to close the file based on name of file
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int CloseFile(char *name)
{
   int i = 0;
   i = GetFDFromName(name);
   if(i == -1)
     return -1;

   UFDTArr[i].ptrfiletable->readoffset = 0;
   UFDTArr[i].ptrfiletable->writeoffset = 0;
   (UFDTArr[i].ptrfiletable->ptrinode->ReferenceCount)--;

   return 0;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : CloseAllFile
// Input Parameters : No input parameters
// Return value of function : Void
// Description of the function : The function is used to implement closeall command to close all the files
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void CloseAllFile()
{
   int i = 0;
   while(i<50)
   {
      if(UFDTArr[i].ptrfiletable != NULL)
      {
         UFDTArr[i].ptrfiletable->readoffset = 0;
         UFDTArr[i].ptrfiletable->writeoffset = 0;
         (UFDTArr[i].ptrfiletable->ptrinode->ReferenceCount)--;
         break;
      }
      i++;
   }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : LseekFile
// Input Parameters : Integer, Integer, Integer
// Return value of function : Integer
// Description of the function : The function is used to implement lseek command to repositions the read/write file offset
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int LseekFile(int fd, int size, int from)
{
 if((fd<0) || (from > 2)) return -1;
 if(UFDTArr[fd].ptrfiletable == NULL) return -1;

 if((UFDTArr[fd].ptrfiletable->mode == READ) || (UFDTArr[fd].ptrfiletable->mode == READ+WRITE))
 {
   if(from == CURRENT)
   {
      if(((UFDTArr[fd].ptrfiletable->readoffset)+size) > UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize)  return -1;

      if(((UFDTArr[fd].ptrfiletable->readoffset)+size) < 0) return -1;

      (UFDTArr[fd].ptrfiletable->readoffset) = (UFDTArr[fd].ptrfiletable->readoffset) + size; 
   }
   else if(from == START)
   {
      if(size > UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) return -1;

      if(size < 0) return -1;

      (UFDTArr[fd].ptrfiletable->readoffset) = size;
   }
   else if(from == END)
   {
      if((UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) + size > MAXFILESIZE) return -1;

      if(((UFDTArr[fd].ptrfiletable->readoffset)+size) < 0) return -1;

      (UFDTArr[fd].ptrfiletable->readoffset) = (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) + size;
   }
  }
  else if(UFDTArr[fd].ptrfiletable->mode == WRITE)
  {
    if(from == CURRENT)
    {
      if(((UFDTArr[fd].ptrfiletable->writeoffset) + size) > MAXFILESIZE)  return -1;

      if(((UFDTArr[fd].ptrfiletable->writeoffset) + size) < 0)  return -1;

      if(((UFDTArr[fd].ptrfiletable->writeoffset) + size) > (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize))
        (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) = (UFDTArr[fd].ptrfiletable->writeoffset) + size; 
        (UFDTArr[fd].ptrfiletable->writeoffset)  =  (UFDTArr[fd].ptrfiletable->writeoffset) + size; 
    }
    else if(from == START)
    {
      if(size > MAXFILESIZE) return -1;
      if(size < 0) return -1;
      if(size > (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize))
         (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize) = size;
      (UFDTArr[fd].ptrfiletable->writeoffset) = size;
    }
    else if(from == END)
    {
      if((UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize)+size > MAXFILESIZE) return -1;

      if(((UFDTArr[fd].ptrfiletable->writeoffset) + size) < 0) return -1;

      (UFDTArr[fd].ptrfiletable->writeoffset) = (UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize)+size;
    }
  }
  return 0;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : ls_file
// Input Parameters : No input parameters
// Return value of function : Void
// Description of the function : The function is used to implement ls command to list all the files
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

void ls_file()
{
   int i = 0;
   PINODE temp = head;

   if(SUPERBLOCKobj.FreeInode == MAXINODE)
   {
      printf("Error : There are no files\n");
      return;
   }

   printf("\nFile Name\tInode number\tFile Size\tLink Count\n");
   printf("---------------------------------------------------------------------\n");
   while(temp!= NULL)
   {
      if(temp->FileType != 0)
      {
         printf("%s\t\t%d\t\t%d\t\t%d\n",temp->FileName,temp->InodeNumber,temp->FileActualSize,temp->LinkCount);
      }
      temp = temp->next;
   }
   printf("----------------------------------------------------------------------\n");
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : fstat_file
// Input Parameters : Integer
// Return value of function : Integer
// Description of the function : The function is used to implement fstat command to give the information about file associated with FD
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int fstat_file(int fd)
{
 PINODE temp = head;
 int i = 0;

 if(fd < 0) return -1;

 if(UFDTArr[fd].ptrfiletable == NULL) return -2;
 
 temp = UFDTArr[fd].ptrfiletable->ptrinode;

 printf("\n-------------Statistical Information about file--------------------\n");
 printf("File Name : %s\n",temp->FileName);
 printf("Inode Number : %d\n",temp->InodeNumber);
 printf("File Size : %d\n",temp->FileSize);
 printf("Actual File Size : %d\n",temp->FileActualSize); 
 printf("Link Count : %d\n",temp->LinkCount);
 printf("Reference Count : %d\n",temp->ReferenceCount);

 if(temp->permission == 1)
   printf("File Permission : Read Only\n");
 else if(temp->permission == 2)
   printf("File Permission : Write Only\n");
 else if(temp->permission == 3)
   printf("File permission : Read & Write\n");
 printf("------------------------------------------\n\n");

 return 0;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : stat_file
// Input Parameters : Character pointer
// Return value of function : Integer
// Description of the function : The function is used to implement stat command to give the information about file
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int stat_file(char *name)
{
 PINODE temp = head;
 int i = 0;

 if(name == NULL) return -1;

 while(temp != NULL)
 {
   if(strcmp(name,temp->FileName) == 0)
     break;
   temp = temp->next;
 }

 if(temp == NULL || temp->FileType == 0) return -2;

 printf("\n-------Statistical Information about file--------\n");
 printf("File Name : %s\n",temp->FileName);
 printf("Inode Number : %d\n",temp->InodeNumber);
 printf("File Size : %d\n",temp->FileSize);
 printf("Actual File Size : %d\n",temp->FileActualSize);
 printf("Link Count : %d\n",temp->LinkCount);
 printf("Reference Count : %d\n",temp->ReferenceCount);

 if(temp->permission == 1)
   printf("File Permission : Read Only\n");
 else if(temp->permission == 2)
   printf("File Permission : Write Only\n");
 else if(temp->permission == 3)
   printf("File permission : Read & Write\n");
 printf("------------------------------------------\n\n");

 return 0;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Name of the function : truncate_File
// Input Parameters : Character pointer
// Return value of function : Integer
// Description of the function : The function is used to implement truncate command to remove the contents of file
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int truncate_File(char *name)
{
   int fd = GetFDFromName(name);
   if(fd == -1)
     return -1;
   
   memset(UFDTArr[fd].ptrfiletable->ptrinode->Buffer,0,1024);
   UFDTArr[fd].ptrfiletable->readoffset = 0;
   UFDTArr[fd].ptrfiletable->writeoffset = 0;
   UFDTArr[fd].ptrfiletable->ptrinode->FileActualSize = 0;
   
   return 0;
}

int main()
{
   char *ptr = NULL;
   int ret = 0, fd = 0, count = 0;
   char command[4][80], str[80], arr[1024];

   InitialiseSuperBlock();
   CreateDILB();
   
   //shell
   while(1)   //infinite listening while
   {
      fflush(stdin);
      strcpy(str,"");

      printf("\nCustomized VFS : >");

     // fgets(str,80,stdin)
       scanf("%[^'\n']s",str);
       
       count = sscanf(str,"%s %s %s %s",command[0],command[1],command[2],command[3]);  //Used to tokanize the string considering space 
       //strtok : used to tokanize string alternate function
       
       if(count == 1)
        {
           if(strcmp(command[0],"ls") == 0)
           {
              ls_file();
           }
           else if(strcmp(command[0],"closeall") == 0)
           {
              CloseAllFile();
              printf("All files closed successfully\n");
              continue;  //time reduce hoto directly loop la parat
           }
           else if(strcmp(command[0],"help") == 0)
           {
              DisplayHelp();
              continue;
           }
           else if(strcmp(command[0],"exit") == 0)
           {
              printf("Terminating the Virtual File System\n");
              break;
           }
           else
           {
              printf("\nERROR : Command not found!!!\n");
              continue;
           }
         }
         else if(count == 2)
         {
           if(strcmp(command[0],"stat") == 0)
           {
              ret = stat_file(command[1]);
              if(ret == -1)
                printf("ERROR : Incorrect parameters\n");
              if(ret == -2)
                printf("ERROR : There is no such file\n");
              continue;
           }
           else if(strcmp(command[0],"fstat") == 0)
           {
              ret = fstat_file(atoi(command[1]));
              if(ret == -1)
                printf("ERROR : Incorrect parameters\n");
              if(ret == -2)
                printf("ERROR : There is no such file\n");
              continue;
           }
           else if(strcmp(command[0],"close") == 0)
           {
              ret = CloseFile(command[1]);
              if(ret == -1)
                printf("ERROR : There is no such file\n");
              continue;
           }
           else if(strcmp(command[0],"rm") == 0)
           {
              ret = rm_File(command[1]);
              if(ret == -1)
                printf("ERROR : There is no such file\n");
              continue; 
           }
           else if(strcmp(command[0],"man") == 0)
           {
              man(command[1]);
           }
           else if(strcmp(command[0],"write") == 0)
           {
               fd = GetFDFromName(command[1]);

               if(fd == -1)
               {
                  printf("ERROR : Incorrect parameter\n");
                  continue;
               }
               fflush(stdin);
               printf("Enter the data : \n");
               //fgets(arr,1024,stdin);
               scanf("%[^'\n']s",arr);

               ret = strlen(arr);
               if(ret == 0)
               {
                  printf("ERROR : Incorrect parameter\n");
                  continue;
               }

               ret = WriteFile(fd,arr,ret);
               if(ret == -1)
                  printf("ERROR : Permission denied\n");
               if(ret == -2)
                 printf("ERROR : There is no sufficient memory to write\n");
               if(ret == -3)
                 printf("ERROR : It is not regular file\n");
               if(ret == -4)
                 printf("ERROR : There is not enough space to write\n");
           }
           else if(strcmp(command[0],"truncate") == 0)
           {
             ret = truncate_File(command[1]);
             if(ret == -1)
               printf("ERROR : Incorrect parameter\n");
           }
           else
           { 
             printf("\nERROR : Command not found !!!\n");
             continue;
           }
         }
         else if(count == 3)
         {
            if(strcmp(command[0],"create") == 0)
            {
               ret = CreateFile(command[1],atoi(command[2]));
               if(ret >= 0)
                  printf("File is successfully created with file descriptor : %d\n",ret);
               if(ret == -1)
                 printf("ERROR: Incorrect Parameters\n");
               if(ret == -2)
                 printf("ERROR: There is no inodes\n");
               if(ret == -3)
                 printf("ERROR: File already exists\n");
               if(ret == -4)
                 printf("ERROR: Memory allocation failure\n");
               continue;
            }
            else if(strcmp(command[0],"open") == 0)
            {
               ret = OpenFile(command[1],atoi(command[2]));
               if(ret >= 0)
                  printf("File is successfully opened with file descriptor : %d\n",ret);
               if(ret == -1)
                 printf("ERROR: Incorrect Parameters\n");
               if(ret == -2)
                 printf("ERROR: File not present\n");
               if(ret == -3)
                 printf("ERROR: Permission denied\n");
               continue;
            }
            else if(strcmp(command[0],"read") == 0)
            {
               fd = GetFDFromName(command[1]);
               if(fd == -1)
               {
                  printf("ERROR : Incorrect parameter\n");
                  continue;
               }
               ptr = (char *)malloc(sizeof(atoi(command[2]))+1);
               if(ptr == NULL)
               {
                  printf("ERROR : Memory allocation failure\n");
                  continue;
               }
               ret = ReadFile(fd,ptr,atoi(command[2]));
               if(ret == -1)
                 printf("ERROR: File not exists\n");
               if(ret == -2)
                 printf("ERROR: Permission denied\n");
               if(ret == -3)
                 printf("ERROR: Reached at the end of file\n");
               if(ret == -4)
                  printf("ERROR : It is not regular file\n");
               if(ret == 0)
                  printf("ERROR : File empty\n");
               if(ret > 0)
               {
                  write(2,ptr,ret);
               }
               continue;
            }
            else
            {
              printf("\nERROR : Command not found!!!\n");
              continue;
            }
         }
         else if(count == 4)
         {
            if(strcmp(command[0],"lseek") == 0)
            {
                fd = GetFDFromName(command[1]);
                if(fd == -1)
                {
                   printf("ERROR : Incorrect Parameter\n");
                   continue;
                }
                ret = LseekFile(fd,atoi(command[2]),atoi(command[3]));
                if(ret == -1)
                { 
                   printf("ERROR : Unable to perform lseek!!\n");
                   continue;
                }
             }
            else
            {
              printf("\nERROR : Command not found!!!\n");
              continue;
            }
         }
         else
         {
           printf("\nERROR : Command not found!!!\n");
           continue;
         }
   } //end of file
   return 0;
}