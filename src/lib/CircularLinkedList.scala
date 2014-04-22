package lib

class CircularLinkedList(headValue : Int){
	var head :Node =new Node( headValue )
	head.next = head
	// tail also points on the only existent node
	var tail = head
	
	def insertFront(value :Int) = {
	    var newNode = new Node( value )
	    // next is the head
	    newNode.next = head
	    head = newNode
	    // tail points on the new node
	    tail.next = head
	}
	
	def insertRear(value :Int) = {
	    var newNode = new Node( value )
	    // newNode is now at the end
	    tail.next = newNode
	    tail = newNode
	    // tail points on the new node
	    tail.next = head
	}
	
	
	def printElements() = {
	  var currentNode = head
	  while( currentNode != tail){
	    println( currentNode.value )
	    currentNode = currentNode.next
	  }
	  //print the tail
	  println( tail.value )
	}
	
	def removeNode( prevNode :Node ) ={
	  var previousNode = prevNode
	  var nodeToRemove = prevNode.next
	  var nextNode = nodeToRemove.next
	  previousNode.next = nextNode
	  
	  // warning if the node to remove is the head, reassign a head and tail
	  if( nodeToRemove == head ){
		tail = previousNode
	    head = nextNode
	    tail.next = head
	  } 

	  // warning if the node to remove is the tail, reassign a head and tail
	  if( nodeToRemove == tail ){
		tail = previousNode
	    head = nextNode
	    tail.next = head
	  } 
	  
	  nodeToRemove = null
	}
	
	def getNthNode( index : Int ) :Node ={
	  var counter = 0 
	  var currentNode = head
	  while( counter < index ){
	    currentNode = currentNode.next
	    counter +=1
	  }
	  currentNode
	}
	
	def jumpToNode ( from :Node, shift : Int ) :Node ={
	  var counter = 0 
	  var currentNode = from
	  while( counter < shift ){
	    currentNode = currentNode.next
	    counter +=1
	  }
	  currentNode
	}
	
	def isSingleton() :Boolean ={
	  if( head.next == head ) true else false
	}
}
