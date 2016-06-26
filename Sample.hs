module Sample where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation
prog :: [Instruction]
prog = [
        Load (ImmValue (3)) 1
        , Push 1
        , Pop 2
        , Compute Sub 0 2 2
        , Push 2
        , Load (ImmValue (2)) 1
        , Push 1
        , Load (ImmValue (1)) 5
        , Load (ImmValue (1)) 3
        , Pop 1
        , Pop 2
        , Compute Equal 1 0 4
        , Branch 4 (Rel 10)
        , Load (ImmValue (1)) 4
        , Compute And 1 4 4
        , Compute Xor 5 4 4
        , Branch 4 (Rel 2)
        , Compute Mul 3 2 3
        , Compute RShift 1 5 1
        , Compute Mul 2 2 2
        , Load (ImmValue (-10)) 4
        , Jump (Rel (-10))
        , Push 3
        , Pop 5
        , Load (ImmValue (1)) 2
        , Store 5 (IndAddr 2)
        , EndProg
        ]