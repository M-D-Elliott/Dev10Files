package com.sg.javamilestone3;

import com.sg.javamilestone3.streams.Server;
import com.sg.javamilestone3.streams.ServerDao;
import java.util.List;

public class Program {
    public static void main(String[] args) {
//        new IntMath().calculate(MathOperator.PLUS, 1, 2);
//        new Dates().run();
//        new BigDecimalFun().run();
        Server server = new Server();
        ServerDao dao = new ServerDao();
        
        dao.addServer(server);
        
        List<Server> dells = dao.getServersByManufacturer("Dell");
        for(Server currentServer : dells) {
            System.out.println(currentServer.getName());
        }

        dells.stream()
                .forEach(s -> System.out.println(s.getName()));

    }
}
