package util.graph;

import util.graph.*;
import util.intset.*;
import java.util.*;
import java.io.*;

public class ColorGraph {
    public  Graph          graph;
    public  int            vertexNb;
    private Stack<Integer> stack;
    public  IntSet         removed;
    public  IntSet         spill;
    public  int[]          color;
    public  int            colorNb;
    public  Node[]         int2Node;
    static  int            NOCOLOR = -1;

    public ColorGraph(Graph graph, int colorNb, int[] preColoredVertices){
	this.graph   = graph;
	this.colorNb = colorNb;
	stack        = new Stack<Integer>(); 
	vertexNb     = graph.nodeCount();
	color        = new int[vertexNb];
	removed      = new IntSet(vertexNb);
	spill        = new IntSet(vertexNb);
	int2Node     = graph.nodeArray();
	for(int v=0; v < vertexNb; v++){
	    int preColor = preColoredVertices[v];
	    if(preColor >= 0 && preColor < colorNb)
		color[v] = preColoredVertices[v];
	    else
		color[v] = NOCOLOR;
	}
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* associe une couleur à tous les sommets se trouvant dans la pile */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public void select()
    {
        while (!stack.empty()) {
            int s = stack.pop();
            IntSet C = neighborsColor(s);
            if (C.getSize() != colorNb - countColored())
                color[s] = chooseAvailableColor(C);
        }

    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* récupère les couleurs des voisins de t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public IntSet neighborsColor(int t)
    {
        IntSet colorSet = new IntSet(colorNb);
        for(NodeList p = int2Node[t].succ(); p!=null; p=p.tail)
            if(color[p.head.label()] != NOCOLOR)
                colorSet.add(color[p.head.label()]);
        return colorSet;


    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* recherche une couleur absente de colorSet */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int chooseAvailableColor(IntSet colorSet)
    {
        for (int i = 0; i < colorNb; i++)
            if (!colorSet.isMember(i)) return i;
        return NOCOLOR;

    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* calcule le nombre de voisins du sommet t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int neighborsNb(int t)
    {
        int nb = 0;
        for(NodeList p = this.int2Node[t].adj(); p!=null; p=p.tail)
            if(!removed.isMember(p.head.label()))
                nb++;
        return nb;

    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* simplifie le graphe d'interférence g                                                                        */
    /* la simplification consiste à enlever du graphe les temporaires qui ont moins de k voisins                   */
    /* et à les mettre dans une pile                                                                               */
    /* à la fin du processus, le graphe peut ne pas être vide, il s'agit des temporaires qui ont au moins k voisin */
    /*-------------------------------------------------------------------------------------------------------------*/
    private int countColored() {
        return (int) Arrays.stream(color)
                .filter(c -> c != NOCOLOR)
                .count();
    }
    public int simplify()
    {
        boolean modif = true;

        while (stack.size() != vertexNb - countColored() && modif) {
            modif = false;

            for (int s = 0; s < int2Node.length; s++) {
                if (neighborsNb(s) < colorNb && color[s] != NOCOLOR) {
                    stack.add(s);
                    removed.add(s);
                    modif = true;
                }

            }
        }
        return stack.size();
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/
    private int chooseVertex() {
        for (int s = 0; s < int2Node.length; s++)
            if (!removed.isMember(s) && color[s] == NOCOLOR) return s;

        return -1;
    }
    public void spill()
    {
        while (stack.size() != vertexNb) {
            int s = chooseVertex();
            if (s < 0) throw new RuntimeException("Could not find a vertex.");
            stack.add(s);
            removed.add(s);
            spill.add(s);
            simplify();
        }

    }


    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/

    public void color()
    {
	this.simplify();
	this.spill();
	this.select();
    }

    public void affiche()
    {
	System.out.println("vertex\tcolor");
	for(int i = 0; i < vertexNb; i++){
	    System.out.println(i + "\t" + color[i]);
	}
    }
    
    

}
