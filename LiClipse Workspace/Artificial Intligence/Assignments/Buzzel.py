goal = [1, 8, 7, 2, 0, 6, 3, 4, 5]
initial_state = [1, 2, 3, 8, 0, 4, 7, 6, 5]


def move_right(state):
    print()    
    newstate = state[:]
    index = newstate.index(0)
    if index not in [6, 7, 8]:
        temp = newstate[index + 3]
        newstate[index + 3] = newstate[index]
        newstate[index] = temp
        return newstate
    else :return None
       
def move_left(state):
    print()
    newstate = state[:]
    index = newstate.index(0)
    if index not in [0, 1, 2]:
        temp = newstate[index - 3]
        newstate[index - 3] = newstate[index]
        newstate[index] = temp
        return newstate
    else:return None
    
def move_up( state):
    print()    
    index = state.index(0)
    newstate = state[:]
    newstate = newstate[:]
    if index not in [0, 3, 6]:
        temp = newstate[index - 1]
        state[index - 1] = state[index]
        state[index] = temp
        return newstate
    else: return None
        
def move_down(state):
    print()
    newstate = state[:]
    index = newstate.index(0)
    if index not in [2, 5, 8]:
        temp = newstate[index + 1]
        newstate[index + 1] = newstate[index]
        newstate[index] = temp
        return newstate
    else :return None
# create Node
# expand Node
def expand_node( node, nodes ):
    expanded_nodes = []
    expanded_nodes.append( create_node( move_up( node.state ), node, "u", node.depth + 1, 0 ) )
    expanded_nodes.append( create_node( move_down( node.state ), node, "d", node.depth + 1, 0 ) )
    expanded_nodes.append( create_node( move_left( node.state ), node, "l", node.depth + 1, 0 ) )
    expanded_nodes.append( create_node( move_right( node.state), node, "r", node.depth + 1, 0 ) )
    expanded_nodes = [node for node in expanded_nodes if node.state != None] #list comprehension!
    return expanded_nodes

class Node:
    def __init__(self,state, parent, action, depth, cost):
         self.state = state
         self.parent = parent
         self.action = action
         self.cost = cost 
         self.depth = depth

def create_node(state, parent=None, action , depth =0, cost=0):
    return Node(state, parent, action, depth, cost)
  
         
#bfs
def bfs(start, goal):
    nodes = []
    nodes.append(create_node(start, None, None, 0, 0))
    while True:
         if len(nodes) == 0: return None
         node = nodes.pop(0)
         if node.state == goal:
            moves = []
            temp = node
            while True:
                moves.insert(0, temp.action)
                if temp.depth == 1: break
                temp = temp.parent
            return moves                
         nodes.extend(expand_node(node, nodes))  
          
def readfile( filename ):
    f = open( filename )
    data = f.read()
    # Get rid of the newlines
    data = data.strip( "\n" )
    #Break the string into a list using a space as a seperator.
    data = data.split( " " )
    state = []
    for element in data:
        state.append( int( element ) )
    return state

# Main method
def main():
    starting_state = readfile( "foo.txt" )
    result = bfs( starting_state, goal )
    if result == None:
        print ("No solution found")
    elif result == [None]:
        print ("Start node was the goal!")
    else:
        print( result)
        print (len(result), " moves")

# A python-isim. Basically if the file is being run execute the main() function.

if __name__ == "__main__":
    main()

         
         
         
         
         
         
         
         
