# sQLux-menu

A java-based GUI for configuring and running the Sinclair QL emulator sQLux (https://github.com/SinclairQL/sQLux).

To run (java version 17+):

      java -jar /home/simon/code/java/sQLuxMenu/store/SqluxMenu.jar

Arguments:

      sQLuxmenu [-d|--dir config_directory] [-s|--sqlux sqlux_binary_path] [-h|--help]

'config_directory' is where the .ini files are stored.
'sqlux_binary_path' is the sQLux binary executable.

Alternatives set the following environment variables:

      SQLUXINI = directory containing .ini files 
      SQLUX = full path to sqlux binary

The config directory and binary can path can also be changed in the GUI. The binary path is stored in each ini file,
allowing different ini files  to run different sqlux binaries. 

![image](https://github.com/user-attachments/assets/ef7096cd-2d6b-4ff0-ba12-31146a0cbc4a)
![image](https://github.com/user-attachments/assets/272df794-eb72-489f-adb1-96993aa92e74)
![image](https://github.com/user-attachments/assets/852066d6-8713-471a-8e7a-48d3874a22e3)
