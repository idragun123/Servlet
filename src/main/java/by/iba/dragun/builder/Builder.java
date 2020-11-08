package by.iba.dragun.builder;

import org.sonatype.aether.RepositoryException;
import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException, RepositoryException, by.iba.dragun.exception.RepositoryException;
}




