#!/usr/bin/env python

from tkinter import *

class App:
    def start(self):
        self.rootWindow = Tk()
        
        self.rootWindow.mainloop()
    
def main():
    a = App()
    a.start()
    
if (__name__ == '__main__'):
    main()