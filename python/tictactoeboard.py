
__all__ = [
    'TicTacToeBoard'
]


# TODO: 
winningMoves = [
    (0,0),(1,0),(2,0),
    (0,1),(1,1),(2,1),
    (0,2),(1,2),(2,2),
    
    (0,0),(0,1),(0,2),
    (1,0),(1,1),(1,2),
    (2,0),(2,1),(2,2),
    
    (0,0),(1,1),(2,2),
    (0,2),(1,1),(2,0)
]

#
# X:
# * horizontal
# * increases toward the right
#
# Y:
# * vertical
# * increases toward the top
# 







class TicTacToeBoard:
    # PROPERTIES
    # currentPlayer
    # cells
    # winningMoves

    

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
    
    @classmethod
    def isValidLocation(cls,location):
        output = isinstance(location,tuple) and \
            (len(location) == 2) and \
            (isinstance(location[0],int)) and \
            (isinstance(location[0],int))
        return output
    
    
    def reset(self):
        self.currentPlayer = self.player1
        self.cells = {}
        self.winningPlayer = self.noPlayer
        
    # TODO:
    def checkPlayerForWinner(self,player):
        #raise Exception("unimplemented")
        for move in self.winningMoves:
            self.checkLocationForWinner(move,player)
    
    # TODO:
    def checkLocationForWinner(self,location,player):
        #raise Exception("unimplemented")
        
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
        if (self.currentPlayer == self.player1):
            self.currentPlayer = self.player2
        else:
            self.currentPlayer = self.player1
    
    def getCurrentPlayer(self):
        return self.currentPlayer
    
    def setCurrentPlayer(self,currentPlayer):
        # guard: currentPlayer must be player1 || player2
        if (currentPlayer != self.player1 and currentPlayer != self.player2):
            raise Exception("Bad argument")
        
        self.currentPlayer = currentPlayer
        
    def makeMove(self,location):
        # guard: validate location
        # guard: is location occupied
        
        # set cell at location to current player
        
        self.setCell(location,self.getCurrentPlayer())
    
    def hasWinner(self):
        "Returns boolean"
        return (self.winningPlayer != self.noPlayer)
    
    def getWinningPlayer(self):
        "Returns either player1 or player2"
        return self.winningPlayer
    
    def setCell(self,location,player):
        """Sets cell to player.
        
        location    tuple (x,y)
        player      character
        """
        self.cells[location] = player
    
    def getCell(self,location):
        # if location is not in cells, assume it is not occupied, noplayer
        if (location not in self.cells):
            return self.noPlayer
        return self.cells[location]
