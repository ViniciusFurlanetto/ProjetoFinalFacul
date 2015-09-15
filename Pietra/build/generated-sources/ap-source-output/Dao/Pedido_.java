package Dao;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-05T19:14:08")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Integer> encaminhado;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;
    public static volatile SingularAttribute<Pedido, Date> dtEmissao;
    public static volatile SingularAttribute<Pedido, Integer> idRepres;
    public static volatile SingularAttribute<Pedido, String> prazo;
    public static volatile SingularAttribute<Pedido, Integer> idCliente;
    public static volatile SingularAttribute<Pedido, Double> valorTotal;

}