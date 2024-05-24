#!/usr/bin/env python3.11


# runs all tests in test class



import tictactoe
import re

class TestTicTacToeBoard:
    
    def disabled_constructor():
        pass
        
        
    def disabled_setplayer():
        pass
    
    
    
    
    def disabled_initializeWinningMoves(self):
        "main test"
        return
        
        instance = tictactoe.TicTacToeBoard()
        
        instance.initializeWinningMoves()
        
        print (instance.winningMoves)
        
        

def runMethodsWithPrefix(cls,prefix):
    # initialize class
    instance = cls()
    
    prefixRe = re.compile(prefix)
    
    methods = cls.__dict__.keys()
    for k in methods:
        if (prefixRe.match(k)):
            doc1 = cls.__dict__[k].__doc__
            print("RUNNING TEST: "+k)
            cls.__dict__[k](instance)
            
        



        
        
def main():
    instance = TestTicTacToeBoard()
    
    runMethodsWithPrefix(TestTicTacToeBoard,'test_')

main()