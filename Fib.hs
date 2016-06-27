module Fib where

import BasicFunctions
import HardwareTypes
import Sprockell
import System
import Simulation
prog :: [Instruction]
prog = [
        Load (ImmValue (10)) 1
        , Push 1
        , Pop 3
        , Load (ImmValue (1)) 2
        , Store 3 (IndAddr 2)
        , Push 0
        , Pop 3
        , Load (ImmValue (2)) 2
        , Store 3 (IndAddr 2)
        , Push 0
        , Pop 3
        , Load (ImmValue (3)) 2
        , Store 3 (IndAddr 2)
        , Load (ImmValue (1)) 1
        , Push 1
        , Pop 3
        , Load (ImmValue (4)) 2
        , Store 3 (IndAddr 2)
        , Load (ImmValue (2)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Load (ImmValue (1)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Pop 1
        , Pop 3
        , Compute Lt 3 1 3
        , Push 3
        , Pop 1
        , Load (ImmValue (1)) 2
        , Compute Xor 1 2 1
        , Branch 1 (Rel 45)
        , Load (ImmValue (2)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Load (ImmValue (1)) 1
        , Push 1
        , Pop 1
        , Pop 3
        , Compute Add 3 1 3
        , Push 3
        , Pop 4
        , Load (ImmValue (2)) 2
        , Store 4 (IndAddr 2)
        , Load (ImmValue (3)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Load (ImmValue (4)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Pop 1
        , Pop 3
        , Compute Add 3 1 3
        , Push 3
        , Pop 4
        , Load (ImmValue (4)) 2
        , Store 4 (IndAddr 2)
        , Load (ImmValue (4)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Pop 3
        , Load (ImmValue (5)) 2
        , Store 3 (IndAddr 2)
        , Load (ImmValue (3)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Pop 3
        , Load (ImmValue (4)) 2
        , Store 3 (IndAddr 2)
        , Load (ImmValue (5)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Pop 3
        , Load (ImmValue (3)) 2
        , Store 3 (IndAddr 2)
        , Jump (Rel (-57))
        , Load (ImmValue (3)) 2
        , Load (IndAddr 2) 2
        , Push 2
        , Pop 3
        , Load (ImmValue (1)) 2
        , Store 3 (IndAddr 2)
        , Push 0
        , Pop 3
        , Load (ImmValue (2)) 2
        , Store 3 (IndAddr 2)
        , Push 0
        , Pop 3
        , Load (ImmValue (3)) 2
        , Store 3 (IndAddr 2)
        , Push 0
        , Pop 3
        , Load (ImmValue (4)) 2
        , Store 3 (IndAddr 2)
        , Push 0
        , Pop 3
        , Load (ImmValue (5)) 2
        , Store 3 (IndAddr 2)
        , EndProg
        ]