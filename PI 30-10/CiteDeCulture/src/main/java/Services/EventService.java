/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Event;
import Entities.Participation;

import Util.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class EventService {

    private Connection cnx;
    private Statement ste;
    private ResultSet rs;

    public EventService() {
        cnx = DataSource.getInstance().getConnexion();

    }

    public void insertEvent(Event e) {
        String req = "insert into Event (NomEvent,CategorieEvent,NbrPlaceDispo,DateEvent,HeureEvent,Affiche) values ('" + e.getNomEvent() + "','" + e.getCategorieEvent() + "','" + e.getNbrPlaceDispo() + "','" + e.getDateEvent() + "','" + e.getHeureEvent() + "','" + e.getAffiche() + "')";

        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Event> readAll() {
        String req = "select * from event";
        List<Event> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Event(rs.getInt("IdEvent"), rs.getString("NomEvent"), rs.getString("CategorieEvent"), rs.getInt("NbrPlaceDispo"), rs.getDate("DateEvent"), rs.getString("HeureEvent"), rs.getString("Affiche")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public List<Event> readById(Event e) {
        String req = "select * from event where IdEvent='" + e.getIdEvent() + "'";
        List<Event> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Event(rs.getInt("IdEvent"), rs.getString("NomEvent"), rs.getString("CategorieEvent"), rs.getInt("NbrPlaceDispo"), rs.getDate("DateEvent"), rs.getString("HeureEvent"), rs.getString("Affiche")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public void deleteEventById(int id) {
        String req = "delete from event where IdEvent=" + id;
        //String req1="delete * from participation JOIN event on participation.IdEvent=event.IdEvent where IdEvent="+id ;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
            //ste.executeUpdate(req1);

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateEvent(Event e, int id) {
        String req = "update event set NomEvent='" + e.getNomEvent() + "',CategorieEvent='" + e.getCategorieEvent() + "',NbrPlaceDispo='" + e.getNbrPlaceDispo() + "',DateEvent='" + e.getDateEvent() + "',HeureEvent='" + e.getHeureEvent() + "',Affiche='" + e.getAffiche() + "' where IdEvent=" + id;
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public List<Event> searchEvent(String search) {
        String req = "select * from event where CategorieEvent like '%" + search + "%'  order by DateEvent asc";
        List<Event> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                while (rs.next()) {
                    list.add(new Event(rs.getInt("IdEvent"), rs.getString("NomEvent"), rs.getString("CategorieEvent"), rs.getInt("NbrPlaceDispo"), rs.getDate("DateEvent"), rs.getString("HeureEvent"), rs.getString("Affiche")));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

   
    public Event getEventById(int idEvent) {
        String req = "select * from event where IdEvent=" + idEvent;

        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                Event event = new Event(rs.getInt("IdEvent"), rs.getString("NomEvent"), rs.getString("CategorieEvent"), rs.getInt("NbrPlaceDispo"), rs.getDate("DateEvent"), rs.getString("HeureEvent"), rs.getString("Affiche"));

                return event;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Event> getParticipatedEvent(int idUser) {
        try {
            List<Event> listeEvents = new ArrayList<>();
            List<Participation> listePArticipations = new ArrayList<>();
            String req = "select * from participation where idUser=" + idUser;
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                listePArticipations.add(new Participation(rs.getInt("IdParticipation"), rs.getInt("IdEvent"), rs.getInt("IdUser")));

            }

            for (Participation participation : listePArticipations) {
                String req2 = "select * from event where idEvent=" + participation.getIdEvent();
                ste = cnx.createStatement();
                rs = ste.executeQuery(req2);
                while (rs.next()) {
                    Event event = new Event(rs.getInt("IdEvent"), rs.getString("NomEvent"), rs.getString("CategorieEvent"), rs.getInt("NbrPlaceDispo"), rs.getDate("DateEvent"), rs.getString("HeureEvent"), rs.getString("Affiche"));

                    listeEvents.add(event);

                }
            }

            List<Event> listDistinct = listeEvents.stream().distinct().collect(Collectors.toList());

            System.out.println("Size ==> " + listDistinct.size());
            System.out.println("listeEvents ==> " + listDistinct);

            return listDistinct;
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
