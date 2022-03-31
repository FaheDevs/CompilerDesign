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
        /*int t;
        while(!stack.empty()){
            t = stack.pop();
            removed.remove(t);
            if(color[t] == NOCOLOR)
                color[t] = chooseAvailableColor(neighborsColor(t));
            if(color[t] == NOCOLOR)
                System.out.println("cannot find a color for vertex "+ t);
        }*/

        while (!stack.empty()) {
            int s = stack.pop();
            IntSet C = neighborsColor(s);

            if (C.getSize() != colorNb - countColored())
                color[s] = chooseAvailableColor(C);
        }

    }
    private int countColored() {
        return (int) Arrays.stream(color)
                .filter(c -> c != NOCOLOR)
                .count();
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
        for(int c=0; c < colorSet.getSize(); c++)
            if(!colorSet.isMember(c))
                return c;
        return NOCOLOR;

    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /* calcule le nombre de voisins du sommet t */
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public int neighborsNb(int t)
    {
        int nb = 0;
        for(NodeList p = this.int2Node[t].succ(); p!=null; p=p.tail)
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

    public int simplify()
    {
        boolean modif = true;
        while (stack.size() != vertexNb - countColored() && modif) {
            modif = false;
            for (int s = 0; s < int2Node.length; s++) {
                if (neighborsNb(s) >= colorNb || removed.isMember(s) || color[s] != NOCOLOR) {
                    continue;
                }
                stack.add(s);
                removed.add(s);
                modif = true;
            }
        }
        return stack.size();
    }
    
    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/
    
    public void spill()
    {
       /* int t;
        while(stack.size() != vertexNb){ // some nodes have not been pushed
            for(t=0; t < vertexNb; t++){
                if(!removed.isMember(t) && color[t] == NOCOLOR){ //t i still in the graph
                    System.out.println("vertex " + t + " is a potential spill");
                    spill.add(t);
                    removed.add(t);
                    stack.push(t);
                    simplify();
                }
            }
        }*/
        while (stack.size() != vertexNb - countColored()) {
            //int s = chooseVertex();
            int s = -1;
            for (int i = 0; i < int2Node.length; i++)
                // pas besoin de vérifier deborde : si x est dans déborde, alors il est dans enleves
                if (!removed.isMember(i) && color[i] == NOCOLOR) s = i;

            if (s < 0) throw new RuntimeException("Could not find a vertex."); // TODO
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
