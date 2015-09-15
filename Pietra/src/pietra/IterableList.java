/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietra;
import java.util.List;
import Dao.Cliente;
import Dao.Item;
import Dao.Usuario;
import Dao.Pedido;
import Dao.Representante;

/**
 *
 *Retirado do site http://www.guj.com.br/534-botoes-para-navegar-para-proximo-e-primeiro
 * e alterado por Vinícius Furlanetto para funcionamento de acordo.
 * @param <E>
 */
public class IterableList<E> {
    private List<E> iterableList;
    private int currentPosition;
    private int collectionSize;
    private IterableList<Cliente> CltList;
    private IterableList<Item> ItemList;
    private IterableList<Usuario> UsrList;
    private IterableList<Pedido> PedList;
    private IterableList<Representante> RepList;    
    private Cliente Clt;
    private Item Item;
    private Usuario Usr;
    private Pedido Ped;
    private Representante Rep;

    public IterableList(List<E> iterableList) {
        this.iterableList = iterableList;
        this.collectionSize = iterableList.size();
        this.currentPosition = 0;
    }

    // Pega um item em uma determinada posição.
    protected E getCollectionItemAt(int position) {
        return getIterableList().get(position);
    }

    // Recupero o primeiro item da minha coleção.
    public E first() {
        setCurrentPosition(0);
        return getCollectionItemAt(0);
    }

    // Recupero o último item da minha coleção.
    public E last() {
        int pos = (this.collectionSize - 1);
        setCurrentPosition(pos);
        
        return getCollectionItemAt(pos);
    }

    // Recupero o próximo item a partir da posição atual.
    public E next() {
        int pos = (getCurrentPosition() + 1);
        if (pos >= getCollectionSize()) pos = (getCollectionSize() - 1);
        setCurrentPosition(pos);
        
        return getCollectionItemAt(pos);
    }

    // Recupero o item anterior a partir da posição atual.
    public E previous() {
        int pos = (getCurrentPosition() - 1);
        if (pos < 0) pos = 0;
        setCurrentPosition(pos);
        
        return getCollectionItemAt(pos);
    }

    
    public List<E> getIterableList() {
        return iterableList;
    }

    public void setIterableList(List<E> iterableList) {
        this.iterableList = iterableList;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }
    
//    public Usuario findUsuarioByID(int id) {        
//        this.setCurrentPosition(0);
//        
//        for (int i = 0; i < this.collectionSize; i++){
//            
//            System.out.println(i);
//            Usr = UsrList.next();
//            
//            if (id == Usr.getIdUsuario()) {
//                System.out.println(i);
//                
//                return UsrList.getCollectionItemAt(i);
//            }
//        }
//        
//        return null;
//    }
}
