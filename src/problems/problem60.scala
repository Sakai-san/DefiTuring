package problems

import lib.CircularLinkedList

object problem60 extends App{
  
	var ring = new CircularLinkedList( 0 )
	for ( i<- 1 to 2012 ) ring.insertRear(i)

	var currentNode = ring.getNthNode(5)
	val shift = 6
	while( ! ring.isSingleton ){
	     // remove the next of current
		ring.removeNode(currentNode)
		currentNode = ring.jumpToNode(currentNode, shift)
	}
	
	println( "the last remaining : ")
	println( ring.getNthNode(0).value + 1 )
	
	// response 1868
}