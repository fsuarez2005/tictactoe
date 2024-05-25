
__all__ = [
    'TicTacToeBoard'
]


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

class TicTacToeBoard:
    # PROPERTIES
    # currentPlayer
    # cells
    # winningMoves

    def __init__(self):
        self.player1 = 'X'
        self.player2 = 'O'
        
        self.currentPlayer = self.player1
        self.cells = {}
        
        
        self.winningMoves = []
    
    @classmethod
    def isValidLocation(cls,location):
        output = isinstance(location,tuple) and \
            (len(location) == 2) and \
            (isinstance(location[0],int)) and \
            (isinstance(location[0],int))
        return output
    
    
    class WinningMove:
        def __init__(self,cell1,cell2,cell3):
            self.cell1 = cell1
            self.cell2 = cell2
            self.cell3 = cell3
    
    def initializeWinningMoves(self):
        # list of tuples of winning moves
        self.winningMoves = [
            WinningMove(0,0,0),
        ]
    
    # TODO: 
    def addWinningMove(self,cell1,cell2,cell3):
        # guard: validate cell locations
        # 0 <= x <= 2
        # 0 <= y <= 2
        
        # append WinningMove to self.winningMoves
        
        
        raise Exception("unimplemented")
    
    # TODO:
    def reset(self):
        raise Exception("unimplemented")
        
    # TODO:
    def checkForWinner(self):
        raise Exception("unimplemented")
        for move in self.winningMoves:
            print(move)
    
    # TODO:
    def checkLocationForWinner(self,locationTuple,player):
        raise Exception("unimplemented")
        pass
    
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
        
    # TODO:
    def makeMove(self,location):
        # guard: validate location
        # guard: is location occupied



        raise Exception("unimplemented")
        pass
    
    
        
    
    def setCell(self,location,player):
        """Sets cell to player.
        
        location    tuple (x,y)
        player      character
        """
        self.cells[location] = player
    
    def getCell(self,location):
        return self.cells[location]
