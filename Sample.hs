module Sample where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation
prog :: [Instruction]
prog = [
        Load (ImmValue 0) 1
        , Load (ImmValue 1) 2
        , Store 1 (IndAddr 2)
        , Push 1
        , Pop 3
        , Load (ImmValue 1) 1
        , Push 1
        , Pop 1
        , Load (ImmValue 1) 2
        , Compute Xor 1 2 1
        , Branch 1 (Rel 12)
        , Load (ImmValue 0) 1
        , Push 1
        , Pop 3
        , Load (ImmValue 1) 2
        , Store 3 (IndAddr 2)
        , Load (ImmValue 1) 1
        , Push 1
        , Pop 3
        , Load (ImmValue 1) 2
        , Store 3 (IndAddr 2)
        , Jump (Rel (-16))
        , EndProg
        ]