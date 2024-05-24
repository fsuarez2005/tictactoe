#!/usr/bin/env python3.11





# uses tkinter 3.11 from homebrew

from tkinter import *
from tkinter import ttk


class TicTacToeBoard:
    # PROPERTIES
    # currentPlayer
    # cells
    # winningMoves
    
    
    class WinningMove:
        pass
    
    def initializeWinningMoves(self):
        
        # list of tuples of winning moves
        self.winningMoves = [
            (0,0,0),
        ]
        
        
    # TODO:
    def reset(self):
        raise Exception("unimplemented")
        pass
        
    # TODO:
    def checkForWinner(self):
        raise Exception("unimplemented")
        for move in self.winningMoves:
            print(move)
    
    # TODO:
    def checkLocationForWinner(self,locationTuple,player):
        raise Exception("unimplemented")
        pass
    
    # TODO:
    def switchPlayer(self):
        if (self.currentPlayer == self.player1):
            self.currentPlayer = self.player2
        else:
            self.currentPlayer = self.player1
        
        
    # TODO:
    def getCurrentPlayer(self):
        return self.currentPlayer
    
    # TODO:
    def setCurrentPlayer(self,currentPlayer):
        self.currentPlayer = currentPlayer
        
    # TODO:
    def makeMove(self,location):
        raise Exception("unimplemented")
        pass
    
    def __init__(self):
        self.player1 = 'X'
        self.player2 = 'O'
        
        self.currentPlayer = self.player1
        self.cells = []
        
        
    def setCell(self,location,player):
        self.cells[location] = player
    
    def getCell(self,location):
        return self.cells[location]
    
    
    
    

class TicTacToeApp:
    def __init__(self):
        self.tttBoard = TicTacToeBoard()
        self.statusLabel = None
        
        
        self.cells = {}
        self.btnHeight = 5
        self.btnWidth = 5

    def buttonAction(self,btn,x,y):
        "Called when button is pressed."
        btn['text'] = self.tttBoard.getCurrentPlayer()
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
                b.grid(column=x,row=y)
                
                # define callback command separately so we can refer to this button
                b['command'] = callBackFactory(b,x,y)
                b['text'] = f"({x},{y})"
        return frm
        
        
        
    def createComponents(self):
        self.rootWindow = Tk()
        self.rootWindow.title('Tic-Tac-Toe')
        
        frm = Frame(self.rootWindow)
        frm.grid()
        
        
        self.statusLabel = Label(frm,text="")
        self.statusLabel.grid(column=0,row=0)
        
        tttfrm = self.createTicTacToeFrame(frm)
        tttfrm.grid(column=0,row=1)
        
        
        self.setStatus("Let's go!")
        
        self.rootWindow.mainloop()

    def setStatus(self,s):
        self.statusLabel['text'] = s
        
        
    def start(self):
        self.createComponents()

# =======================================================

def main():
    tttApp = TicTacToeApp()
    tttApp.start()

if (__name__ == '__main__'):
    pass
    main()




