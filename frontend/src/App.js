import React, {Component} from 'react';
import bluesky_logo from './img/bluesky.jpeg';
import instagram_logo from './img/instagram.png';
import lastfm_logo from './img/lastfm.png';
import mastodon_logo from './img/mastodon.png';
import github_logo from './img/github.png';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            url: '',
        };
    }

    componentDidMount() {
        const url = "https://kotprotiv.dev:8080/obsession";
        fetch(url)
            .then(response => response.json())
            .then(result => {
                this.setState({
                    name: result.name,
                    url: result.url,
                });
            })
            .catch((error) => console.log(error));
    }

    render() {
        console.log('obsession', this.state);
        return (
            <div>
                <h2>As you can see, I am not a frontend dev</h2>
                <br/>
                <h3>Some links</h3>
                <a rel="me" href="https://bsky.app/profile/kotprotiv.bsky.social">
                    <img src={bluesky_logo} className="img-with-margin" alt="bluesky logo"></img>
                </a>
                <a rel="me" href="https://instagram.com/kotprotiv">
                    <img src={instagram_logo} className="img-with-margin" alt="instagram logo"></img>
                </a>
                <a rel="me" href="https://last.fm/user/kotprotiv">
                    <img src={lastfm_logo} className="img-with-margin" alt="lastfm logo"></img>
                </a>
                <a rel="me" href="https://mastodon.social/@kotprotiv">
                    <img src={mastodon_logo} className="img-with-margin" alt="mastodon logo"></img>
                </a>
                <a rel="me" href="https://github.com/kotprotiv">
                    <img src={github_logo} className="img-with-margin" alt="github logo"></img>
                </a>
                <br/>
                <h3>Obsession of the week: {this.state.name}</h3>
                <div className="iframe-video-player">
                    <iframe src={this.state.url} title="YouTube video player" frameBorder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                            referrerPolicy="strict-origin-when-cross-origin" allowFullScreen
                            className="iframe-video-player-enter"></iframe>
                </div>
            </div>
        );
    }
}

export default App;