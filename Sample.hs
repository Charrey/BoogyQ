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
        , Pop 3
        , Load (ImmValue (2)) 2
        , Store 3 (IndAddr 2)
        , EndProg
        ]