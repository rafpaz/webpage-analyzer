import React, {Component} from 'react';

class LinksTable extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <h3>Links Data</h3>
                <div className="container">
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                {this.props.headers.map((header, i) => (
                                        <th scope="col" key={i}>{header}</th>
                                    ))}
                            </tr>
                        </thead>
                        <tbody>
                            {this.props.isObject && Object.entries(this.props.data).map((item, i) => (
                                    <tr key={i}>
                                        {item.map(cell => (
                                            <td>{cell}</td>
                                        ))}
                                    </tr>
                                ))}
                            {!this.props.isObject && this.props.map((item, i) => (
                                <tr>
                                    {Object.entries(item).map((cell) => (
                                            <td>{item.cell}</td>
                                    ))}
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default LinksTable;