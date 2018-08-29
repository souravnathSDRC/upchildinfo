package org.sdrc.childinfo.repository;


/**
 * Repository class for <code>User</code> domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Harekrishna Panigrahi
 * 
 */



public interface UserRepository {

    /**
     * Retrieve <code>User</code>s from the data store by last name, returning all Users whose last name <i>starts</i>
     * with the given name.
     *
     * @param lastName Value to search for
     * @return a <code>Collection</code> of matching <code>User</code>s (or an empty <code>Collection</code> if none
     *         found)
     */

//    /**
//     * Retrieve an <code>User</code> from the data store by id.
//     *
//     * @param id the id to search for
//     * @return the <code>User</code> if found
//     * @throws org.springframework.dao.DataRetrievalFailureException
//     *          if not found
//     */
//    SamikshyaUser findById(int id) throws DataAccessException;


    /**
     * Save an <code>User</code> to the data store, either inserting or updating it.
     *
     * @param User the <code>User</code> to save
     * @see BaseEntity#isNew
     */

}

