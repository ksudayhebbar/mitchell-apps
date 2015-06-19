package com.mitchell.examples.claim.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import com.mitchell.examples.exception.ServiceDAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

@Component
public class LookUpFactory
{
    public static final String LOSSOFINFO_LOOKUP_SQL = "SELECT ID,LOSS_CAUSE FROM LOSSOFINFO_LOOKUP";
    @Autowired
    private JdbcTemplate template;

    private final Map<Integer, String> lossInfoLookup = new TreeMap<Integer, String>();

    @PostConstruct
    public void init()
    {
        fillLossInfoLookup();

    }

    private void fillLossInfoLookup()
    {
        Connection jdbcConnection = null;

        PreparedStatement selectPS = null;

        try
        {
            jdbcConnection = template.getDataSource().getConnection();
            jdbcConnection.setAutoCommit(false);
            selectPS = jdbcConnection.prepareStatement(LOSSOFINFO_LOOKUP_SQL, ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = selectPS.executeQuery();
            while (resultSet.next())
            {
                final String strId = resultSet.getString("ID");
                final String strCause = resultSet.getString("LOSS_CAUSE");
                Integer id = strId != null ? Integer.valueOf(strId) : null;
                if (id != null)
                {
                    lossInfoLookup.put(id, strCause);
                }
            }
        } catch (SQLException e)
        {

            throw new ServiceDAOException("Loss cause Look up initialization failed  ", e);
        } finally
        {
            JdbcUtils.closeStatement(selectPS);
            JdbcUtils.closeConnection(jdbcConnection);
        }
    }

    public Map<Integer, String> getLossInfoLookup()
    {
        return lossInfoLookup;
    }
}
