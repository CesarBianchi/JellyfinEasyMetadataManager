/*
 * Copyright (C) 2026 cesarbianchi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.lariflix.jemm.core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lariflix.jemm.dtos.nfo.JemmNFO;
import com.lariflix.jemm.dtos.nfo.Movie;
import com.lariflix.jemm.forms.ShowNFOStructure;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author cesarbianchi
 */
public class LoadNFOFile {
    private String nfoFilePath = new String();
    private String NFOType = new String();
    private JemmNFO NFOObject = new JemmNFO();
    
    public LoadNFOFile() {
    
    }
    
    public LoadNFOFile(String cFile) {
        this.setNfoFilePath(cFile);
        this.loadNFOType();
    }
    
    public String getNfoFilePath() {
        return nfoFilePath;
    }

    public void setNfoFilePath(String nfoFilePath) {
        this.nfoFilePath = nfoFilePath;
    }
    
    private void setNFOType() throws IOException {
        String cNFOFIle = this.getNfoFilePath();
        String content = Files.readString(Path.of(cNFOFIle));

        if (content.contains("<movie>")) {
            this.NFOType = "MOVIE";
        } else if (content.contains("<tvshow>")) {
            this.NFOType = "TV SHOW";
        } else if (content.contains("<episodedetails>")) {
            this.NFOType = "EPISODES";            
        } else if (content.contains("<album>")) {
            this.NFOType = "AUDIO";
        } else if (content.contains("<track>")) {
            this.NFOType = "AUDIO";
        }        

    }

    public String getNFOType() {
        return NFOType;
    }

    public void loadXMLFile() throws IOException{
        //1* Identify the type of media into NFO File
        this.loadNFOType();                
        if (!this.getNFOType().isEmpty()){            
            if (this.getNFOType().equals("MOVIE")){                               
                this.NFOObject.setMovie(this.loadNFOForMovie());
            }
        } else {
            System.out.println("No NFO File defined to load.");
        }
    }
    
    private void loadNFOType() {
        if (this.getNFOType().isEmpty()){
            try {
                this.setNFOType();
            } catch (IOException ex) {
                System.getLogger(ShowNFOStructure.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }    
    
    private Movie loadNFOForMovie() {
        Movie movie = new Movie();
        File NFOFile = new File(this.getNfoFilePath());
        XmlMapper xmlMapper = new XmlMapper();
        
        try {
            xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            movie = xmlMapper.readValue(NFOFile, Movie.class);            
        } catch (IOException ex) {
            System.getLogger(ShowNFOStructure.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return movie;
    }

    public JemmNFO getNFOObject() {
        return NFOObject;
    }

    public DefaultMutableTreeNode getTree() {
        
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("File: " + this.nfoFilePath);
        
        if (this.getNFOType().equals("MOVIE")){
            DefaultMutableTreeNode movieNode  = this.loadMovieTree();
            node.add(movieNode);
            
        } else if (this.getNFOType().equals("AUDIO")){
            //TO DO TO DO
        }   
        
        return node;
    }
    
    private DefaultMutableTreeNode loadMovieTree(){
        DefaultMutableTreeNode movieNode = new DefaultMutableTreeNode("Movie");
        movieNode.add(new DefaultMutableTreeNode("Title: " + this.NFOObject.getMovie().getTitle()));
        movieNode.add(new DefaultMutableTreeNode("Original Title: " + this.NFOObject.getMovie().getOriginaltitle()));
        movieNode.add(new DefaultMutableTreeNode("Overview: " + this.NFOObject.getMovie().getPlot()));
        movieNode.add(new DefaultMutableTreeNode("Premiere Date: " + this.NFOObject.getMovie().getPremiered().toString()));
        movieNode.add(new DefaultMutableTreeNode("Studio: " + this.NFOObject.getMovie().getStudio()));
        movieNode.add(new DefaultMutableTreeNode("Country: " + this.NFOObject.getMovie().getCountry()));
        movieNode.add(new DefaultMutableTreeNode("Credits: " + this.NFOObject.getMovie().getCredits()));
        
        //Ratings
        DefaultMutableTreeNode movieRatings = new DefaultMutableTreeNode("Ratings");
        for (int nI = 0; nI < this.NFOObject.getMovie().getRatings().size(); nI++ ){
            DefaultMutableTreeNode rating = new DefaultMutableTreeNode("Rating");

            rating.add(new DefaultMutableTreeNode("Value: " + this.NFOObject.getMovie().getRatings().getRating().get(nI).getValue() ));
            rating.add(new DefaultMutableTreeNode("Votes: " + this.NFOObject.getMovie().getRatings().getRating().get(nI).getVotes() ));
            movieRatings.add(rating);
        }
        movieNode.add(movieRatings);
                
        //Genres
        DefaultMutableTreeNode movieGenres = new DefaultMutableTreeNode("Genres");
        for (int nI = 0; nI < this.NFOObject.getMovie().getGenre().size(); nI++ ){            
            movieGenres.add(new DefaultMutableTreeNode("Genre: " + this.NFOObject.getMovie().getGenre().get(nI) ));            
        }
        movieNode.add(movieGenres);
        
        //Tags
        DefaultMutableTreeNode movieTags = new DefaultMutableTreeNode("Tags");
        for (int nI = 0; nI < this.NFOObject.getMovie().getTag().size(); nI++ ){            
            movieTags.add(new DefaultMutableTreeNode("Tag: " + this.NFOObject.getMovie().getTag().get(nI) ));            
        }
        movieNode.add(movieTags);
        
        //Actors
        DefaultMutableTreeNode movieStaff = new DefaultMutableTreeNode("Staff");
        for (int nI = 0; nI < this.NFOObject.getMovie().getActor().size(); nI++ ){            
            DefaultMutableTreeNode people = new DefaultMutableTreeNode("People");
            
            people.add(new DefaultMutableTreeNode("Name: " + this.NFOObject.getMovie().getActor().get(nI).getName() ));
            people.add(new DefaultMutableTreeNode("Role: " + this.NFOObject.getMovie().getActor().get(nI).getRole() ));
            movieStaff.add(people);
        }
        movieNode.add(movieStaff);
        
        return movieNode;
    }
    
}
