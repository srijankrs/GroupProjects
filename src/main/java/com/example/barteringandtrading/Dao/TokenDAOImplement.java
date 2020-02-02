package com.example.barteringandtrading.Dao;

import com.example.barteringandtrading.Model.Token;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TokenDAOImplement implements TokenDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveUserEmail(String email, int userId) {
           Session session=null;
        try {
            session=sessionFactory.getCurrentSession();
            Token token= new Token();
            token.setEmailId(email);
            token.setTokenID(userId);
            session.save(token);
        }
        catch (Exception e)
        {
           log.error("Exception in saving UserEmail In Token Table {}",e.getMessage());
        }
        finally {
                 session.flush();
        }

    }

    @Override
    public boolean updateToken(String email, String authenticationToken, String secretKey) {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();
            Query theQuery = session.createQuery("Update Token set authenticationToken = :authenticationToken , secretKey = :secretKey where emailId =:userEmail ");
            theQuery.setParameter("authenticationToken", authenticationToken);
            theQuery.setParameter("userEmail", email);
            theQuery.setParameter("secretKey", secretKey);
            int result = theQuery.executeUpdate();
            if(result == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception exception)
        {
            System.out.println("Error while updating token :: " + exception.getMessage());
            return false;
        }
        finally
        {
            session.flush();
        }
    }

    @Override
    public int getTokenDetail(String email) {
        Session session = null;
        try
        {
            session = sessionFactory.getCurrentSession();

            Query<Token> query = session.createQuery("from Token where emailId =:userEmail");
            query.setParameter("userEmail", email);

            List<Token> tokenDetails = query.list();

            if(tokenDetails.size() > 0)
            {
                return tokenDetails.get(0).getTokenID();
            }
            else
            {
                return 0;
            }

        }
        catch(Exception exception)
        {
            log.error("Exception while getting token ID :: " + exception.getMessage());
        }
        finally
        {
            session.flush();
        }

        return 0;
    }

    @Override
    public int tokenAuthentication(String token, int emailId) {
        return 0;
    }
}
