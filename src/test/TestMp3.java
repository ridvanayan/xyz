package test;

import com.google.gson.Gson;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.File;
import java.util.LinkedHashMap;

/**
 *
 * @author ridvanayan
 */
public class TestMp3
{

    /**
     * @param args the command line arguments
     *
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws Exception
    {        
        String rootFolder = "C:\\test";
        Mp3File mp3file;
        String ext, path;
        int startIndex;
        for (File f : new File(rootFolder).listFiles())
        {
            path = f.getPath();
            startIndex = path.lastIndexOf(".")+1;
            ext = f.getPath().substring(startIndex, path.length());
            if(!ext.endsWith("mp3"))
            {
                System.out.println(f.getName()+" is not an mp3 file!");
                continue;
            }
            mp3file = new Mp3File(f);

            System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
            System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
            System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
            System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
            System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
            System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));

            System.out.println(new Gson().toJson(mp3file));
            System.out.println("");

            if (mp3file.hasId3v1Tag())
            {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                System.out.println("Track: " + id3v1Tag.getTrack());
                System.out.println("Artist: " + id3v1Tag.getArtist());
                System.out.println("Title: " + id3v1Tag.getTitle());
                System.out.println("Album: " + id3v1Tag.getAlbum());
                System.out.println("Year: " + id3v1Tag.getYear());
                System.out.println("Genre: " + id3v1Tag.getGenre() + " (" + id3v1Tag.getGenreDescription() + ")");
                System.out.println("Comment: " + id3v1Tag.getComment());
            }

            if (mp3file.hasId3v2Tag())
            {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                System.out.println("Track: " + id3v2Tag.getTrack());
                System.out.println("Artist: " + id3v2Tag.getArtist());
                System.out.println("Title: " + id3v2Tag.getTitle());
                System.out.println("Album: " + id3v2Tag.getAlbum());
                System.out.println("Year: " + id3v2Tag.getYear());
                System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
                System.out.println("Comment: " + id3v2Tag.getComment());
                System.out.println("Composer: " + id3v2Tag.getComposer());
                System.out.println("Publisher: " + id3v2Tag.getPublisher());
                System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
                System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
                System.out.println("Copyright: " + id3v2Tag.getCopyright());
                System.out.println("URL: " + id3v2Tag.getUrl());
                System.out.println("Encoder: " + id3v2Tag.getEncoder());
                byte[] albumImageData = id3v2Tag.getAlbumImage();
                if (albumImageData != null)
                {
                    System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
                    System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
                }
            }

        }
//        Mp3File mp3file = new Mp3File(rootFolder + "\\Duman - Sor Bana Pisman miyim.mp3");
//        Mp3File mp3file = new Mp3File(rootFolder + "\\Mozart - Presto.mp3");
//        Mp3File mp3file = new Mp3File(rootFolder + "\\SampleAudio_0.7mb.mp3");

//        mp3file = new Mp3File(rootFolder + "\\Commercial DEMO - 12.mp3");
//        mp3file = new Mp3File(rootFolder + "\\Commercial DEMO - 06.mp3");
//        mp3file = new Mp3File(rootFolder + "\\Commercial DEMO - 09.mp3");
//        mp3file = new Mp3File(rootFolder + "\\Duman - Yürek - trackmp3.download.mp3");
    }

}
