
import java.util.*;
class BT {
    static class Node{
        int data ;
        Node left ;
        Node right;

        public Node(int data){
            this.data = data ;
            this.left = null ;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null ;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrder(Node root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void levelOrder(Node root){
        if(root==null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node current = q.remove();
            if(current == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(current.data+" ");
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }
            }
        }
    }
    public static void levelOrder2(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node current = queue.poll ();

            System.out.print(current.data+" ");
            if(current.left!=null){
                queue.offer(current.left);
            }
            if(current.right!=null){
                queue.offer(current.right);
            }
        }

    }

    public static int countNodes(Node root){

        if(root==null){
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);


        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum  = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }
    public static int Height(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        int maxHeight = Math.max(leftHeight, rightHeight) + 1;

        return maxHeight;
    }
    //diameter of the tree with approach1 O{n^2} time complexity
    public static int Diameter(Node root){

        if(root == null){
            return 0;
        }
        int diameter1 = Diameter(root.left);
        int diameter2 = Diameter(root.right);
        int diameter3 = Height(root.left) + Height(root.right) + 1;

        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }


    //diameter of the tree with the O(n) time complexity approach2

    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam ;
        }
    }
    public static TreeInfo Diameter2(Node root){

        if(root == null){
           return  new TreeInfo(0,0);
        }
        TreeInfo left = Diameter2(root.left);
        TreeInfo right = Diameter2(root.right);

        int myHeight = Math.max (left.ht , right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(diam3 , Math.max(diam1 , diam2));

        TreeInfo myInfo = new TreeInfo(myHeight , mydiam);
        return myInfo ;
    }

    public static void mirrorTree(Node root){
        if(root==null){
            return;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        Node temp = root.left;
        root.left = root.right ;
        root.right = temp;

        
    }
    

   public static void main(String[] args) {
    int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(arr);

    System.out.println("Preorder:");
    preorder(root);

    System.out.println("\nInorder:");
    inOrder(root); 

    System.out.println("\nPostorder:");
    postOrder(root); 

    System.out.println("\nLevel Order (with lines):");
    levelOrder(root);

    System.out.println("\nLevel Order (flat):");
    levelOrder2(root);

    System.out.println("\nCount Nodes:");
    System.out.println(countNodes(root));

    System.out.println("\nSum of all Nodes:");
    System.out.println(sumOfNodes(root));

    System.out.println("\nHeight of the tree");
    System.out.println(Height(root));

    System.out.println("\nDiameter of the Tree:");
    System.out.println(Diameter(root));

    System.out.println("\nDiameter in O(n) approach");
    System.out.println(Diameter2(root).diam);

    mirrorTree(root);
    System.out.println("\nMirrored Tree:");
    levelOrder(root);
}

}



