package cn.edu.njucm.Eye;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Crawler implements PageProcessor {
	private List<String> result = new ArrayList<String>();
	private int counter;
	private String startURL;
	private String keyword;
    private Site site;
    private Spider spider;

    @Override
    public void process(Page page) {
    	counter--;
    	boolean bfind = false;
    	if(counter <= 0)
    		return;
        List<Element> h1 = new ArrayList<Element>();
        h1 = page.getHtml().getDocument().getElementsByTag("h1");
        if(h1.size() == 0)
        	return;
        for(int i = 0; i < h1.size(); i++){
        	if(h1.get(i).text().matches(".*" + keyword + ".*")){
        		bfind = true;
        		Element nx = h1.get(i).nextElementSibling();
        		while( nx != null){
        			result.add(nx.text());
        			nx = nx.nextElementSibling();
        		}
        	}
        }
    	if(bfind && counter > 0){
    		page.addTargetRequests(page.getHtml().links().all());
    	}
    }

    @Override
    public Site getSite() {
        return site;
    }
    

    public void start() {
        (spider = Spider.create(this)).addUrl(startURL).run();
    }
    
    public Crawler(int counter, String startURL, String keyword){
    	site = Site.me().setRetryTimes(3).setSleepTime(100);
    	this.counter = counter;
    	this.startURL = startURL;
    	this.keyword = keyword;
    }
    
    public List<String> getRes(){
    	return result;
    }
    
    public void stop() {
        spider.stop();
    }

}