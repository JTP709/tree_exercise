class BinaryTree (input: Int){
    private var root: Node = Node(input)

    fun insert(value: Int, node: Node = root) {
        when{
            value < node.value && node.left == null -> node.left = Node(value)
            value < node.value && node.left != null -> insert(value, node.left!!)
            value > node.value && node.right == null -> node.right = Node(value)
            value > node.value && node.right != null -> insert(value, node.right!!)
        }
    }

    fun depthFirstSearch(value: Int, node: Node? = root): Boolean {
        return when {
            node == null -> false
            node.value == value -> true
            depthFirstSearch(value, node.left) -> true
            depthFirstSearch(value, node.right) -> true
            else -> false
        }
    }

    fun inOrderTraversal(node: Node? = root): List<Int> {
        return when {
            node != null -> inOrderTraversal(node.left)
                            .union(listOf(node.value))
                            .union(inOrderTraversal(node.right).toList())
                            .toList()
            else -> emptyList()
        }
    }
}

data class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}
