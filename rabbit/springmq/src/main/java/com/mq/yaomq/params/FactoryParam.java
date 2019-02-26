package com.mq.yaomq.params;

/**
 * @create by  单耀
 * @create date  2019/2/26
 */
public class FactoryParam {
    private String url;
    private String vhost;
    private String username;
    private String passpword;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVhost() {
        return vhost;
    }

    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasspword() {
        return passpword;
    }

    public void setPasspword(String passpword) {
        this.passpword = passpword;
    }
}
