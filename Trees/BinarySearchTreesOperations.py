# Problem Statement : Implementing BinarySearchTree operations 
# Here we implement insertion, searching a node and deletion 

class BinarySearchTree:
    def __init__(self, value):
        self.value = value
        self.left_child = None
        self.right_child = None

    # Function for insertion
    def insert_node(self, value):
        if value <= self.value and self.left_child:
            self.left_child.insert_node(value)
        elif value <= self.value:
            self.left_child = BinarySearchTree(value)
        elif value > self.value and self.right_child:
            self.right_child.insert_node(value)
        else:
            self.right_child = BinarySearchTree(value)
    
    # For finding the node
    def find_node(self, value):
        if value < self.value and self.left_child:
            return self.left_child.find_node(value)
        if value > self.value and self.right_child:
            return self.right_child.find_node(value)

        return value == self.value # If both the if conditions return false we compare and return if our value is the same
        # as the current node, else we return false
    
    # For removing he node
    def remove_node(self, value, parent):
        if value < self.value and self.left_child:
            return self.left_child.remove_node(value, self)
        elif value < self.value:
            return False
        elif value > self.value and self.right_child:
            return self.right_child.remove_node(value, self)
        elif value > self.value:
            return False
        else:
            # For node with no children and is the left child to its parent
            if self.left_child is None and self.right_child is None and self == parent.left_child:
                parent.left_child = None
                self.clear_node()
            
            # For node with no children and is the right child to its parent
            elif self.left_child is None and self.right_child is None and self == parent.right_child:
                parent.right_child = None
                self.clear_node()
            
            # For nodes with one left child and it is left child from it's parent 
            elif self.left_child and self.right_child is None and self == parent.left_child:
                parent.left_child = self.left_child
                self.clear_node()
                
            # For nodes with one left child and it is right child from it's parent
            elif self.left_child and self.right_child is None and self == parent.right_child:
                parent.right_child = self.left_child
                self.clear_node()
            
            # For node with one right child and it is the left child from it's parent
            elif self.right_child and self.left_child is None and self == parent.left_child:
                parent.left_child = self.right_child
                self.clear_node()

            # For node with one right child and it is the right child from it's parent
            elif self.right_child and self.left_child is None and self == parent.right_child:
                parent.right_child = self.right_child
                self.clear_node()

            # For nodes with both left and right children. 
            else:
                self.value = self.right_child.find_minimum_value() # We first find the minimum_value in the right subtree 
                # of the node we want to remove and set it in the place of the node we want to remove
                self.right_child.remove_node(self.value, self) # Now we remove our value from the right subtree

            return True
    # function to remove a node
    def clear_node(self):
        self.value = None
        self.left_child = None

    # inorder to find the minimum value in a subtree
    def find_minimum_value(self):
        if self.left_child:
            return self.left_child.find_minimum_value()
        else:
            return self.value