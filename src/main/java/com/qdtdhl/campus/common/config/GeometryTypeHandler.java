package com.qdtdhl.campus.common.config;


import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.postgis.Geometry;
import org.postgis.PGgeometry;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Geometry.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class GeometryTypeHandler extends BaseTypeHandler<Geometry> {

        /** insert / update 时调用
         * @param ps
         * @param i
         * @param parameter
         * @param jdbcType
         * @throws SQLException
         */
        @Override
        public void setNonNullParameter(PreparedStatement ps, int i, Geometry parameter, JdbcType jdbcType) throws SQLException {
            PGgeometry geometry = new PGgeometry();
            geometry.setGeometry(parameter);
            ps.setObject(i, geometry);
        }

        /** 查询时使用
         * @param rs
         * @param columnName
         * @return
         * @throws SQLException
         */
        @Override
        public Geometry getNullableResult(ResultSet rs, String columnName) throws SQLException {
            if(rs.getObject(columnName)==null){
                return null;
            }
            PGgeometry pGgeometry=(PGgeometry)(rs.getObject(columnName));
            return pGgeometry.getGeometry();
        }

        @Override
        public Geometry getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
            PGgeometry pGgeometry=(PGgeometry)(rs.getObject(columnIndex));
            return pGgeometry.getGeometry();
        }

        /** CallableStatement和存储过程相关
         *
         * @param cs
         * @param columnIndex
         * @return
         * @throws SQLException
         */
        @Override
        public Geometry getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
            PGgeometry pGgeometry=(PGgeometry)(cs.getObject(columnIndex));
            return pGgeometry.getGeometry();
        }

    }

