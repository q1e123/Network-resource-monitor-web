package com.q1e123.NetworkResourceMonitorWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, Systems.machine_id, true "
                                +"FROM Users "
                                +"INNER JOIN Systems On Users.system_id = Systems.id "
                                +"WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, IF(user_role = 1, 'ROLE_ADMIN', 'ROLE_USER') " +
                                        "FROM Users " +
                                        "WHERE username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/allsystems").hasRole("ADMIN")
                .antMatchers("/allusers").hasRole("ADMIN")
                .antMatchers("/usage-data-for/{machine-id}").hasRole("ADMIN")
                .antMatchers("/environment-variables-for/{usage-id}").hasRole("ADMIN")
                .antMatchers("/cpu-usage-for/{usage-id}").hasRole("ADMIN")
                .antMatchers("/network-usage-for/{usage-id}").hasRole("ADMIN")
                .antMatchers("/user-list-for/{usage-id}").hasRole("ADMIN")
                .antMatchers("/monitor/{machineId}").hasRole("ADMIN")
                .antMatchers("/system-management").hasRole("ADMIN")
                .antMatchers("/my-machine").hasAnyRole("ADMIN", "USER")
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncodedr() {
        return NoOpPasswordEncoder.getInstance();
    }
}
