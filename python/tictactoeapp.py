#!/usr/bin/env python

# Copyright (c) 2024 Frank Suarez
#
# Permission is hereby granted, free of charge, to any person obtaining a copy of this
# software and associated documentation files (the "Software"), to deal in the Software
# without restriction, including without limitation the rights to use, copy, modify,
# merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
# permit persons to whom the Software is furnished to do so, subject to the following
# conditions:
#
# The above copyright notice and this permission notice shall be included in all copies
# or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
# INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
# PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
# HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
# CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
# OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


#
# TicTacToeApp
# Tk Window for Tic-Tac-Toe app
#
# 
# TODO: clean up
#


from tkinter import *

from versiontest import *
from tictactoeboard import *

class TicTacToeApp:
    def __init__(self):
        self.tttBoard = TicTacToeBoard()
        self.statusLabel = None
        
        
        self.cells = {}
        self.btnHeight = 5
        self.btnWidth = 5
        
        # tk Y to tictactoeboard Y
        self.yMap = {
            0: 2,
            1: 1,
            2: 0
        }
        
        self.xMap = {
            0: 0,
            1: 1,
            2: 2
        }
        
    
    def buttonAction(self,btn,x,y):
        "Called when button is pressed. x and y are mapped to button locations."
        btn['text'] = self.tttBoard.getCurrentPlayer()
        btn['state'] = 'disabled'
        self.tttBoard.makeMove((self.xMap[x],self.yMap[y]))
        
        self.tttBoard.checkPlayerForWinner(self.tttBoard.getCurrentPlayer())
        if (self.tttBoard.hasWinner()):
            winningPlayer = self.tttBoard.getWinningPlayer()
            if (winningPlayer == self.tttBoard.player1):
                playerName = 'Player 1'
            elif (winningPlayer == self.tttBoard.player2):
                playerName = 'Player 2'
            else:
                raise Exception("Winning Player not set correctly.")
            
            self.setStatus(f"{playerName} has won.")
            # player won, lock all buttons
            for b in self.cells:
                self.cells[b]['state'] = 'disabled'
            
        
        self.tttBoard.switchPlayer()
    
    
    def createTicTacToeFrame(self,parent=None):
        
        # utility function for buttons
        def callBackFactory(btn,x,y):
            "Creates a 0-arity callback function for Button command."
            return (lambda:self.buttonAction(btn,x,y))
        
        
        frm = Frame(parent,padx=5,pady=5)
        frm.grid()
        
        
        for x in range(0,3):
            for y in range(0,3):
                
                b = Button(
                    frm,
                    height=self.btnHeight,
                    width=self.btnWidth
                )
                self.cells[(x,y)] = b
                
                
                b.grid(column=x,row=y)
                
                # define callback command separately so we can refer to this button
                b['command'] = callBackFactory(b,x,y)
                #b['text'] = f"({x},{y})\n({self.xMap[x]},{self.yMap[y]})"
        return frm
    
    def reset(self):
        # reset window
        for b in self.cells:
            self.cells[b]['state'] = 'normal'
            self.cells[b]['text'] = ''
            
        # reset game board model
        self.tttBoard.reset()
        
    def createComponents(self):
        self.rootWindow = Tk()
        self.rootWindow.title('Tic-Tac-Toe')
        
        frm = Frame(self.rootWindow)
        frm.grid()
        
        
        resetBtn = Button(frm,text="Reset",command=self.reset)
        resetBtn.grid(column=0,row=0)
        
        self.statusLabel = Label(frm,text="")
        self.statusLabel.grid(column=0,row=1)
        
        tttfrm = self.createTicTacToeFrame(frm)
        tttfrm.grid(column=0,row=2)
        
        
        self.setStatus("Let's go!")
        
        self.rootWindow.mainloop()

    def setStatus(self,s):
        self.statusLabel['text'] = s
        
        
    def start(self):
        self.createComponents()

# =======================================================

def main():
    if (not minimalPythonVersion(3,12,0)):
        raise Exception('Old Python')
    
    
    tttApp = TicTacToeApp()
    tttApp.start()

if (__name__ == '__main__'):
    main()




