module Gcd where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation
prog :: [Instruction]
prog = [
        Load (ImmValue (27)) 1
        , Push 1
        , Pop 3
        , Load (ImmValue (1)) 2
        , Store 3 (IndAddr 2)
        , Load (ImmValue (12)) 1
        , Push 1
        , Pop 3
        , Load (ImmValue (2)) 2
        , Store 3 (IndAddr 2)
        , Load (DirAddr 1) 2
        , Push 2
        , Load (DirAddr 2) 2
        , Push 2
        , Pop 1
        , Pop 3
        , Compute NEq 3 1 3
        , Push 3
        , Pop 1
        , Load (ImmValue (1)) 2
        , Compute Xor 1 2 1
        , Branch 1 (Rel 43)
        , Load (ImmValue (1)) 1
        , Push 1
        , Pop 1
        , Load (ImmValue (1)) 2
        , Compute Xor 1 2 1
        , Branch 1 (Rel 36)
        , Load (DirAddr 1) 2
        , Push 2
        , Load (DirAddr 2) 2
        , Push 2
        , Pop 1
        , Pop 3
        , Compute Gt 3 1 3
        , Push 3
        , Pop 1
        , Load (ImmValue (1)) 2
        , Compute Xor 1 2 1
        , Branch 1 (Rel 13)
        , Load (DirAddr 1) 2
        , Push 2
        , Load (DirAddr 2) 2
        , Push 2
        , Pop 1
        , Pop 3
        , Compute Sub 3 1 3
        , Push 3
        , Pop 4
        , Load (ImmValue (1)) 2
        , Store 4 (IndAddr 2)
        , Jump (Rel (12))
        , Load (DirAddr 2) 2
        , Push 2
        , Load (DirAddr 1) 2
        , Push 2
        , Pop 1
        , Pop 3
        , Compute Sub 3 1 3
        , Push 3
        , Pop 4
        , Load (ImmValue (2)) 2
        , Store 4 (IndAddr 2)
        , Jump (Rel (-53))
        , Load (DirAddr 2) 2
        , Push 2
        , Pop 3
        , Load (ImmValue (1)) 2
        , Store 3 (IndAddr 2)
        , EndProg
        ]