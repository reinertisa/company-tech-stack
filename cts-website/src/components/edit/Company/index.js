import CompanyForm from "./Form";
import CompanyList from "./List";
import ReadableWithTemplate from "../../Templates/ReadableWith";
import useGet from "../../hooks/getData";
import {useEffect, useState} from "react";
import axios from "axios";

export default function CompanyPage() {
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState(null);
    const [error, setError] = useState('');

    useEffect(() => {
        let mount = true;
        const loadData = async () => {
            try {
                setLoading(true);
                const rez = await axios.get('http://localhost:8080/api/v1/companies');
                if (mount) {
                    setData(rez?.data);
                }
                setLoading(false);
            } catch (err) {
                setError(err);
            }
        }
        // noinspection JSIgnoredPromiseFromCall
        loadData();

        return () => {
            mount = false;
        }

    }, []);

    let body = loading ? 'Loading' : '';
    if (data) {
        body = (
            <CompanyList data={data} />
        );
    } else if (error) {
        body = error;
    }


    const saveHandler = (val) => {
        console.log('Company saved.')
        console.log(val);
        setData([...data, val]);
    }

    return (
        <ReadableWithTemplate>
            <CompanyForm onSave={saveHandler} />
            {body}
        </ReadableWithTemplate>
    );
}