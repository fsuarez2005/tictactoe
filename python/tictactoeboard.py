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
# TicTacToeBoard 
#
#
# TODO: clean up
# TODO: add docstrings



__all__ = [
    'TicTacToeBoard'
]


class TicTacToeBoard:
    # TODO
    ""
    
    #
    # X:
    # * horizontal
    # * increases toward the right
    #
    # Y:
    # * vertical
    # * increases toward the top
    #



    def __init__(self):
        self.noPlayer = ' '
        self.player1 = 'X'
        self.player2 = 'O'
        
        self.winningMoves = [
            ((0,0),(1,0),(2,0)),
            ((0,1),(1,1),(2,1)),
            ((0,2),(1,2),(2,2)),
            
            ((0,0),(0,1),(0,2)),
            ((1,0),(1,1),(1,2)),
            ((2,0),(2,1),(2,2)),
            
            ((0,0),(1,1),(2,2)),
            ((0,2),(1,1),(2,0))
        ]
        
        self.currentPlayer = self.player1
        self.cells = {}
        self.winningPlayer = self.noPlayer
    
    # TODO: not used
    @classmethod
    def isValidLocation(cls,location):
        output = isinstance(location,tuple) and \
            (len(location) == 2) and \
            (isinstance(location[0],int)) and \
            (isinstance(location[0],int))
        return output
    
    
    def reset(self):
        # TODO
        ""
        
        self.currentPlayer = self.player1
        self.cells = {}
        self.winningPlayer = self.noPlayer
        
    def checkPlayerForWinner(self,player):
        # TODO
        ""
        
        for move in self.winningMoves:
            self.checkLocationForWinner(move,player)
    
    def checkLocationForWinner(self,location,player):
        # TODO
        ""
        
        if (location[0] in self.cells and \
            location[1] in self.cells and \
            location[2] in self.cells):
            # prevent Index errors
            # locations occupied
            if (self.cells[location[0]] == player and \
                self.cells[location[1]] == player and \
                self.cells[location[2]] == player):
                self.winningPlayer = player
        
    
    def switchPlayer(self):
        # TODO
        ""
        
        if (self.currentPlayer == self.player1):
            self.currentPlayer = self.player2
        else:
            self.currentPlayer = self.player1
    
    def getCurrentPlayer(self):
        #TODO
        ""
        
        return self.currentPlayer
    
    def setCurrentPlayer(self,currentPlayer):
        # TODO
        ""
        
        # guard: currentPlayer must be player1 || player2
        if (currentPlayer != self.player1 and currentPlayer != self.player2):
            raise Exception("Bad argument")
        
        self.currentPlayer = currentPlayer
        
    def makeMove(self,location):
        # TODO
        ""
        
        # guard: validate location
        # guard: is location occupied
        
        # set cell at location to current player
        
        self.setCell(location,self.getCurrentPlayer())
    
    def hasWinner(self):
        # TODO
        "Returns boolean"
        return (self.winningPlayer != self.noPlayer)
    
    def getWinningPlayer(self):
        # TODO
        
        "Returns either player1 or player2"
        return self.winningPlayer
    
    def setCell(self,location,player):
        """Sets cell to player.
        
        location    tuple (x,y)
        player      character
        """
        self.cells[location] = player
    
    def getCell(self,location):
        # TODO
        ""
        
        # if location is not in cells, assume it is not occupied, noplayer
        if (location not in self.cells):
            return self.noPlayer
        return self.cells[location]
