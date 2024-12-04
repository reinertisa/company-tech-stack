import {map, toNumber} from 'lodash';
import axios from "axios";

export default function CompanyList({data = [], onDelete}) {

    const deleteHandler = async (evt) => {
        evt.preventDefault();
        evt.stopPropagation();

        let companyId;
        const closestAncestor = evt.target.closest('button[data-id]');
        if (closestAncestor && closestAncestor.getAttribute('data-id')) {
            companyId = toNumber(closestAncestor.getAttribute('data-id'));
            if (companyId) {
                try {
                    await axios.delete(`http://localhost:8080/api/v1/companies/${companyId}`)
                    onDelete(companyId);
                } catch (err) {
                    console.log(err);
                }
            }
        }
    };

    return (
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Size</th>
                    <th>Industry</th>
                    <th>Country</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            {map(data, (val) => {
                return (
                    <tr key={val?.id}>
                        <td>{val?.name}</td>
                        <td>{val?.type}</td>
                        <td>{val?.size}</td>
                        <td>{val?.industry}</td>
                        <td>{val?.country}</td>
                        <td>
                            <button
                                data-id={val?.id}
                                type="button"
                                onClick={deleteHandler}
                            >
                                Delete
                            </button>
                        </td>
                    </tr>
                );
            })}
            </tbody>
        </table>
    );
}