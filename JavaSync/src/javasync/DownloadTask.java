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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class DownloadTask implements Runnable {

    private final LinkStore linkStore;

    public DownloadTask(LinkStore linkStore) {
        this.linkStore = linkStore;
    }

    @Override
    public void run() {
//        while (true) {
        synchronized (linkStore) {
            try {
                System.out.println("WAIT");
                linkStore.wait(); // block thread and unlock sychronized
                System.out.println("WORK");
            } catch (InterruptedException ex) {
                Logger.getLogger(DownloadTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        }
    }

}
