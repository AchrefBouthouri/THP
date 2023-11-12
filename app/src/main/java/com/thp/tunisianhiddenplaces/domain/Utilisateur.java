package com.thp.tunisianhiddenplaces.domain;

public class Utilisateur {
        private String username;
        private String email;
        private String password;

        // Constructeur
        public Utilisateur(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
}
