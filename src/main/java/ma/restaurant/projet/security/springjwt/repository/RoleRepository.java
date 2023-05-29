package ma.restaurant.projet.security.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import ma.restaurant.projet.security.springjwt.models.ERole;
import ma.restaurant.projet.security.springjwt.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
