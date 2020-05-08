package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer,Airport> idMap;
	
	public Model() {
		idMap = new HashMap<Integer,Airport>();
	}
	
	public void creaGrafo(int x) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		dao.loadAllAirports(idMap);
		
		Graphs.addAllVertices(this.grafo, idMap.values());
		
		// creazione archi
		
		List<Comune> comuni = dao.voliDistanzaMinima(idMap, x);
		
		for(Comune c : comuni) {
			Graphs.addEdge(this.grafo, c.getaPartenza(), c.getaArrivo(), c.getMedia());
		}
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	/**
	 * metodo per stampare grafo
	 * @return
	 */
	public String stampaGrafo() {
		String e="";
		for(DefaultWeightedEdge E :grafo.edgeSet()) {
			e+=grafo.getEdgeSource(E)+" -> "+grafo.getEdgeTarget(E)+"   : "+grafo.getEdgeWeight(E)+" miglia\n";
		}
		return e;
	}
	
	
	public boolean controllaTxt (String p) {
		char c;
		boolean result = true;
		
		for(int i=0;i<p.length();i++){
            c = p.charAt(i);
            if(!((Character.isDigit(c)))){
                result = false;
                return result;
            }
        }
        
		return result;
	}
}
