#!/usr/bin/env python3.11


# uses tkinter 3.11 from homebrew
import tkinter
from tkinter import *
from tkinter import ttk


class TicTacToeBoard:
    
    
    
    pass
    



class TicTacToeApp:
    
    
    
    def __init__(self):
        self.cells = {}
        self.btnHeight = 2
        self.btnWidth = 2

    def buttonAction(self,btn,x,y):
        "Called when button is pressed."
        btn['text'] = 'O'
        print(f"Button {n}: {btn} was pressed.")
        
    def callBackFactory(self,btn,x,y):
        "Creates a 0-arity callback function for Button command."
        return (lambda:self.buttonAction(btn,x,y))
    
    def createComponents(self):
        self.rootWindow = Tk()
        frm = Frame(self.rootWindow)
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
                b['command'] = self.callBackFactory(b,x,y)
            
        
        self.rootWindow.mainloop()


        
        
    def start(self):
        self.createComponents()


def main():
    tttApp = TicTacToeApp()
    tttApp.start()


#main()


def lambdaFactory(s):
    return (lambda: f"String = {s}")

def testLambda():
    s1 = "Hello"
    c1 = lambdaFactory(s1)
    
    
    s1 = "Bye"
    c2 = lambdaFactory(s1)
    
    
    print(c1())
    print(c2())

main()