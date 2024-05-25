#!/usr/bin/env python3.12

from tictactoeboard import *
import unittest

import inspect

class TestTicTacToeBoard(unittest.TestCase):
    
    def setUp(self):
        self.instance = TicTacToeBoard()
    
    def tearDown(self):
        pass
    
    def test_getCurrentPlayer(self):
        self.assertEqual(self.instance.getCurrentPlayer(),'X')
        
    def test_setCurrentPlayer(self):
        # good
        self.instance.setCurrentPlayer(self.instance.player1)
        self.instance.setCurrentPlayer(self.instance.player2)
        
        # bad, throws exception
        with self.assertRaises(Exception) as cm:
            self.instance.setCurrentPlayer('1')
    
    def test_isValidLocation(self):
        o = TicTacToeBoard.isValidLocation((1,2,2))
        print(o)
        
    
    @unittest.skip("")
    def test_constructor(self):
        print(self.instance.cells)
    
    # switchPlayer
    def test_switchPlayer(self):
        self.assertEqual(self.instance.currentPlayer,'X')
        self.instance.switchPlayer()
        self.assertEqual(self.instance.currentPlayer,'O')
        self.instance.switchPlayer()
        self.assertEqual(self.instance.currentPlayer,'X')
    
    def test_init(self):
        pass


if (__name__ == '__main__'):
    unittest.main();
