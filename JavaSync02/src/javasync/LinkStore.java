/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package javasync;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class LinkStore implements Runnable {

    private URL playlist;
    private Queue<String> links;

    public LinkStore(String playlistAddress) throws MalformedURLException {
        this.playlist = new URL(playlistAddress);
        this.links = new LinkedBlockingDeque<>();
    }

    public Queue<String> getLinks() {
        return links;
    }
    
    @Override
    public void run() {
        System.out.println("LINK STORE READY");
        
        links.clear();
        
        retrievePlaylist();

        while (!links.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LinkStore.class.getName()).log(Level.SEVERE, null, ex);
            }

            synchronized (this) {
                System.out.println("NOTIFY");
                notifyAll();
            }
        }

    }

    private void retrievePlaylist() {
        try (Scanner scanner = new Scanner(playlist.openStream())) {
            while (scanner.hasNextLine()) {
                String address = scanner.nextLine();
                links.add(address);
            }
        } catch (IOException ex) {
            Logger.getLogger(LinkStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
