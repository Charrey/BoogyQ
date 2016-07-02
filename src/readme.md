---------------------------------------------------------- |
BoogyQ Compiler - By Hans van der Laan and Pim van Leeuwen |
---------------------------------------------------------- |

Welcome to our BoogyQ compiler!

In order to compile a .boog BoogyQ file, you need to place it in BoogyQ/src/toplevel.

Then, run the main method of toplevel/Main. User dialog will help you select the correct file and show errors if any.
The command ":r" can be used to reload the file without executing Main.main() again.

Once successfully compiled, a .hs file will appear in the BoogyQ folder.

In order to execute the program, open this file in Haskell and enter the query "main".