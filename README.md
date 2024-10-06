# sQLux-menu

A java-based GUI for configuring and running the Sinclair QL emulator sQLux (https://github.com/SinclairQL/sQLux).

To run (java version 17+):

      java -jar /home/simon/code/java/sQLuxMenu/store/SqluxMenu.jar

Arguments:

      sQLuxmenu [-d|--dir config_directory] [-i initial.ini] [-s|--sqlux sqlux_binary_path] [-v|--version] [-h|--help]

'config_directory' is where the .ini files are stored.
'initial.ini' is a ini file to load on startup from the giden config_directory.
'sqlux_binary_path' is the sQLux binary executable.

Alternatives set the following environment variables:

      SQLUXINI = directory containing .ini files 
      SQLUX = full path to sqlux binary

The config directory and binary can path can also be changed in the GUI. The binary path is stored in each ini file,
allowing different ini files  to run different sqlux binaries. 

![image](https://github.com/user-attachments/assets/42289b59-d5f2-4245-9ee4-5bd5e6d2915e)
![image](https://github.com/user-attachments/assets/3b469465-46a8-4fbf-a74d-683f74ccdc6e)
![image](https://github.com/user-attachments/assets/5737452c-8987-4a78-8063-1b6b409ff22e)
![image](https://github.com/user-attachments/assets/927e68a3-6c20-4495-b80e-bc7b0f4d5635)
