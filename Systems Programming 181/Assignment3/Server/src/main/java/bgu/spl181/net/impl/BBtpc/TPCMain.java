package bgu.spl181.net.impl.BBtpc;

import bgu.spl181.net.api.bidi.MVRProtocol;
import bgu.spl181.net.srv.Dall;
import bgu.spl181.net.srv.EncoderDecoder;
import bgu.spl181.net.srv.Server;

import java.util.function.Supplier;

public class TPCMain {

    public static void main (String[] args) {

        Dall dall = new Dall();

        Supplier supplierPr = new Supplier() {
            @Override
            public Object get() {
                return new MVRProtocol(dall);
            }
        };
        Supplier supplierED = new Supplier() {
            @Override
            public Object get() {
                return new EncoderDecoder();
            }
        };
        Server server = Server.threadPerClient(Integer.parseInt(args[0]), supplierPr, supplierED);
        server.serve();
    }

}
