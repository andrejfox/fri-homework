## Repo for all of my homework at FRI-LJ

#### I have a intellj external tool to automagicaly preform tests from one button on the currently focused file:
Program: `/bin/bash`
Argiments: `-c "rm -rf results/* && ./tj.exe $FileName$ tests/$FileNameWithoutExtension$_testi/ results && rm -f $FileNameWithoutExtension$.class"`
Work directory: `$FileDir$`
