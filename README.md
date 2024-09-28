# sQLux-menu

A java-based GUI for configuring and running the Sinclair QL emulator sQLux

To run (java version 17+):

      java -jar /home/simon/code/java/sQLuxMenu/store/SqluxMenu.jar

Arguments:

      sQLuxmenu [-d|--dir config_directory] [-s|--sqlux sqlux_binary_path] [-h|--help]

'config_directory' is where the .ini files are stored.
'sqlux_binary_path' is the sQLux binary executable.

Alternatives set the following environment variables:

      SQLUXINI = directory containing .ini files 
      SQLUX = full path to sqlux binary
