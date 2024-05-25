#!/usr/bin/env python3.12


# runs all tests in test class

import unittest

import tictactoe
import re

class TestTicTacToeBoard(unittest.TestCase):
    
    def test_constructor(self):
        instance = tictactoe.TicTacToeBoard()
        self.assertNotEqual(instance,None)
    
    
    def disabled_initializeWinningMoves(self):
        "main test"
        return
        
        instance = tictactoe.TicTacToeBoard()
        
        instance.initializeWinningMoves()
        
        print (instance.winningMoves)
        
        

            
        



        
        
def main():
    unittest.main()

main()